package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class GitPullRequestCompletionOptions {

    private boolean bypassPolicy;
    private String bypassReason;
    private boolean deleteSourceBranch;
    private String mergeCommitMessage;
    private String mergeStrategy;
    private boolean squashMerge;
    private boolean triggeredByAutoComplete;

    public GitPullRequestCompletionOptions() {
        // Empty
    }

    public boolean isBypassPolicy() {
        return bypassPolicy;
    }

    public String getBypassReason() {
        return bypassReason;
    }

    public boolean isDeleteSourceBranch() {
        return deleteSourceBranch;
    }

    public String getMergeCommitMessage() {
        return mergeCommitMessage;
    }

    public String getMergeStrategy() {
        return mergeStrategy;
    }

    public boolean isSquashMerge() {
        return squashMerge;
    }

    public boolean isTriggeredByAutoComplete() {
        return triggeredByAutoComplete;
    }
}
