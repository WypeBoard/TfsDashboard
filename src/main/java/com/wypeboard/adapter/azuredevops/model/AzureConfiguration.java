package com.wypeboard.adapter.azuredevops.model;

import com.wypeboard.adapter.azuredevops.AzureFilters;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class AzureConfiguration {
    private String accessToken;
    private String baseUrl;
    private String repositoryId;
    private EnumMap<AzureFilters, String> filtersList = new EnumMap<>(AzureFilters.class);
    private List<String> targets = new ArrayList<>();

    public String getProjectApiUrl() {
        StringBuilder s = new StringBuilder();
        s.append(baseUrl)
                .append("/")
                .append(repositoryId)
                .append("/_apis/git/repositories/")
                .append(repositoryId)
                .append("/pullrequests")
                .append("?");
        filtersList.forEach((key, value) ->
                s.append(key.getRequestParam())
                        .append("=")
                        .append(value)
                        .append("&"));
        s.append("api-version=");
        s.append("7.0");
        return s.toString();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }


    public List<String> getTargets() {
        return targets;
    }

    public static class Builder {
        public String accessToken;
        public String repositoryId;
        public String baseUrl;
        private EnumMap<AzureFilters, String> filtersList = new EnumMap<>(AzureFilters.class);
        public List<String> targets = new ArrayList<>();

        public Builder() {
        }

        public Builder withAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder withRepositoryId(String repositoryId) {
            this.repositoryId = repositoryId;
            return this;
        }

        public Builder withBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder withFilter(AzureFilters filter, String parameter) {
            this.filtersList.put(filter, parameter);
            return this;
        }

        public Builder withTargets(List<String> targets) {
            this.targets = targets;
            return this;
        }

        public AzureConfiguration build() {
            AzureConfiguration config = new AzureConfiguration();
            config.accessToken = accessToken;
            config.repositoryId = repositoryId;
            config.baseUrl = baseUrl;
            config.filtersList = filtersList;
            config.targets = targets;
            return config;
        }
    }
}
