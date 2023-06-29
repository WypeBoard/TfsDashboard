package com.wypeboard.adapter.azuredevops;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AzureDevOps {

    private AzureClient client;

    public AzureDevOps() {
        this.client = new AzureClient();
    }

    public void getRepositoryData(List<String> targetRefs) {
        client.

    }
}
