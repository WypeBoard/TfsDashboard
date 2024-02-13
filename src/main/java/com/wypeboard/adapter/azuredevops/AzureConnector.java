package com.wypeboard.adapter.azuredevops;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wypeboard.core.exception.AdoCoreException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AzureConnector {

    @Value("${com.wypeboard.connector.azure_token}")
    private static String AUTHENTICATIONTOKEN;

    public AzureConnector(@Value("${com.wypeboard.connector.azure_token}") String token) {
        AzureConnector.AUTHENTICATIONTOKEN = token;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

    public static <T> T sendRequestAndParseResponse(String requestMethod, String requestUrl, Class<T> responseType) {
        return sendRequestAndParseResponse(requestMethod, requestUrl, responseType, null);
    }

    public static <T> T sendRequestAndParseResponse(String requestMethod, String requestUrl, Class<T> responseType, String jsonBody) {
        final HttpURLConnection uc = getHttpURLConnection(requestMethod, requestUrl);

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

    private static HttpURLConnection getHttpURLConnection(String requestMethod, String urlString) {
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

        String userpass = ":" + AUTHENTICATIONTOKEN;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
        urlConnection.setRequestProperty("Authorization", basicAuth);

        urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        urlConnection.setRequestProperty("Accept", "application/json");
        return urlConnection;
    }

}
