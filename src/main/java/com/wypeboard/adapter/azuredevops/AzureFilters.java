package com.wypeboard.adapter.azuredevops;

public enum AzureFilters {
    TARGET_REF("searchCriteria.targetRefName", AzureOperationTypes.GET),
    ;

    private AzureOperationTypes operation;
    private String requestParam;


    AzureFilters(String requestParam, AzureOperationTypes operation) {
        this.operation = operation;
        this.requestParam = requestParam;
    }

    public AzureOperationTypes getOperation() {
        return operation;
    }

    public String getRequestParam() {
        return requestParam;
    }
}
