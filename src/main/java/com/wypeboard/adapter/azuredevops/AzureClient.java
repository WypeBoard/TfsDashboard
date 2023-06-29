package com.wypeboard.adapter.azuredevops;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wypeboard.core.exception.AdoCoreException;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

// https://source.netcompany.com/tfs/Netcompany/ATP0005/_git/ATP0005?version=GBky/dev/5.0&path=/gradle-projekter/buildSrc/src/main/java/kombit/ky/azuredevops
public class AzureClient {

    @Value("${azuredevops.client.token}")
    private String authenticationToken;
    private List<AzureFilters> filters;

    private static final String ADO_BASE_API_URL_PROJECT = "https://source.netcompany.com/tfs/Netcompany/ATP0005/_apis";
    private static final String ADO_BASE_API_URL_ORGANIZATION = "https://source.netcompany.com/tfs/Netcompany/_apis";
    private static final String ADO_API_VERSION_PROJECT = "7.0";
    private static final String ADO_API_VERSION_ORGANIZATION = "7.0-preview";

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

    public AzureClient() {
    }

    public Object fetchInformationFromAzureDevOps() {
        String requestUrl = getProjectApiUrl()
    }


    private static HttpURLConnection getHttpURLConnection(String requestMethod, String urlString, String authenticationToken) {
        final HttpURLConnection urlConnection;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            // PATCH requires special handling: https://bugs.openjdk.org/browse/JDK-7016595
            if (requestMethod.equals("PATCH")) {
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            } else {
                urlConnection.setRequestMethod(requestMethod);
            }
            urlConnection.setDoOutput(true);
        } catch (IOException e) {
            throw new AdoCoreException(e);
        }

        String userpass = ":" + authenticationToken;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
        urlConnection.setRequestProperty("Authorization", basicAuth);

        urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        urlConnection.setRequestProperty("Accept", "application/json");
        return urlConnection;
    }

    private <T> T sendRequestAndParseResponse(String requestMethod, String requestUrl, Class<T> responseType, String jsonBody) {
        final HttpURLConnection uc = getHttpURLConnection(requestMethod, requestUrl, authenticationToken);

        try {
            if (jsonBody != null) {
                OutputStream writer = uc.getOutputStream();
                writer.write(jsonBody.getBytes());
                writer.flush();
            }

            if (uc.getResponseCode() != HttpURLConnection.HTTP_OK) {
                //logger.lifecycle("Got HTTP response " + uc.getResponseCode() + " " + uc.getResponseMessage() + " for request to URL " + requestUrl + " with body:\n" + jsonBody);
                throw new AdoCoreException("Got non-OK HTTP status " + uc.getResponseCode() + " " + uc.getResponseMessage() + " with body:\n" + new String(uc.getErrorStream().readAllBytes(), StandardCharsets.UTF_8));
            }
            InputStream reader = uc.getInputStream();
            return objectMapper.readValue(reader.readAllBytes(), responseType);
        } catch (IOException e) {
            //logger.lifecycle("Unexpected IOException: " + e);
            throw new AdoCoreException(e);
        }
    }

    /**
     * Construct the full URL to use for making API requests
     *
     * @param component   The part of the URL following the <code>/_apis/</code> part of the URL.
     *                    The component should <em>not</em> include a version of the API nor query parameters.
     * @param queryParams Query parameters to be used in the request.
     *                    Should <em>not</em> include the <code>version</code> parameter. This is automatically added.
     *                    Query parameters are <em>expected to already be URL-encoded.</em>
     * @return full URL usable for making API requests
     */
    private String getApiUrl(String baseurl, String component, Map<String, String> queryParams, String apiVersion) {
        StringBuilder s = new StringBuilder();
        s.append(baseurl);
        s.append(component);
        s.append("?");
        queryParams.forEach((key, value) -> {
            s.append(key);
            s.append("=");
            s.append(value);
            s.append("&");
        });
        s.append("api-version=");
        s.append(apiVersion);
        return s.toString();
    }

    private String getProjectApiUrl(String component, Map<String, String> queryParams) {
        return getApiUrl(ADO_BASE_API_URL_PROJECT, component, queryParams, ADO_API_VERSION_PROJECT);
    }

    private String getOrganizationApiUrl(String component, Map<String, String> queryParams) {
        return getApiUrl(ADO_BASE_API_URL_ORGANIZATION, component, queryParams, ADO_API_VERSION_ORGANIZATION);
    }

    private String getProjectApiUrl(String component) {
        return getProjectApiUrl(component, Map.of());
    }

    private String getOrganizationApiUrl(String component) {
        return getOrganizationApiUrl(component, Map.of());
    }

    /**
     *
     */
    public AzureClient addFilter(AzureFilters filter) {
        if (!filters.isEmpty() && this.filters.get(0).getOperation().equals(filter.getOperation())) {
            throw new AdoCoreException("Multiple different types of URL requests are being made");
        }
        this.filters.add(filter);
        return this;
    }


}
