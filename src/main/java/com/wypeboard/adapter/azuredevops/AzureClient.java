package com.wypeboard.adapter.azuredevops;


import com.wypeboard.adapter.azuredevops.model.PullrequestResponse;
import com.wypeboard.adapter.azuredevops.model.ThreadsResponse;

import java.util.EnumMap;
import java.util.Map;

public class AzureClient {

    //    @Value("${azuredevops.client.token}")
    private final Map<AzureFilters, String> filters = new EnumMap<>(AzureFilters.class);

    private static final String ADO_BASE_API_URL_PROJECT = "https://source.netcompany.com/tfs/Netcompany/ATP0005/_apis";
    private static final String ADO_API_VERSION_PROJECT = "7.0";

    // Specific branch: https://source.netcompany.com/tfs/Netcompany/ATP0005/_apis/git/repositories/ATP0005/pullRequests/<id number>
    // Target branch: https://source.netcompany.com/tfs/Netcompany/ATP0005/_apis/git/repositories/ATP0005/pullrequests?searchCriteria.targetRefName=<refs/heads/<branch>>&searchCriteria.status=all&$top=1000&api-version=7.0
    public AzureClient() {
        // Empty
    }

    public PullrequestResponse fetchPullRequest() {
        String requestUrl = getProjectApiUrl("/git/repositories/ATP0005/pullrequests");
        return AzureConnector.sendRequestAndParseResponse("GET", requestUrl, PullrequestResponse.class);
    }

    public ThreadsResponse fetchPullRequestThreads(int pullrequestId) {
        String requestUrl = getProjectApiUrl(String.join("/", "/git/repositories/ATP0005/pullrequests", Integer.toString(pullrequestId), "threads"));
        return AzureConnector.sendRequestAndParseResponse("GET", requestUrl, ThreadsResponse.class);
    }

    /**
     * Construct the full URL to use for making API requests
     *
     * @param component The part of the URL following the <code>/_apis/</code> part of the URL.
     *                  The component should <em>not</em> include a version of the API nor query parameters.
     * @return full URL usable for making API requests
     */
    private String getApiUrl(String baseurl, String component, String apiVersion) {
        StringBuilder s = new StringBuilder();
        s.append(baseurl);
        s.append(component);
        s.append("?");
        filters.forEach((key, value) ->
                s.append(key.getRequestParam())
                        .append("=")
                        .append(value)
                        .append("&"));
        s.append("api-version=");
        s.append(apiVersion);
        return s.toString();
    }

    private String getProjectApiUrl(String component) {
        return getApiUrl(ADO_BASE_API_URL_PROJECT, component, ADO_API_VERSION_PROJECT);
    }

    /**
     *
     */
    public AzureClient addFilter(AzureFilters filter, String value) {
        this.filters.put(filter, value);
        return this;
    }
}
