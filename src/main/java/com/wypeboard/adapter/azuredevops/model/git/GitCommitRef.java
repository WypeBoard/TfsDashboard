package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class GitCommitRef {

    private String commitId;
    private String url;

    public GitCommitRef() {
    }

    public String getCommitId() {
        return commitId;
    }

    public String getUrl() {
        return url;
    }
}
