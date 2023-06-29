package com.wypeboard.adapter.azuredevops;

public enum AzureOperationTypes {

    GET("GET"),
    CREATE("POST"),
    UPDATE("PATCH"),
    RESOLVE("PATCH");

    private final String requestMethod;

    AzureOperationTypes(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
