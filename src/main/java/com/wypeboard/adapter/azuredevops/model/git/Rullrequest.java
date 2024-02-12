package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class Rullrequest {

    private String artifactId;
    private IdentityRef autoCompleteSetBy;
    private IdentityRef closedBy;
    private OffsetDateTime closedDate;
    private int codeReviewId;
    private Collection<GitCommitRef> commits;
    private GitPullRequestCompletionOptions completionOptions;
    private OffsetDateTime completionQueueTime;
    private IdentityRef createdBy;
    private OffsetDateTime creationDate;
    private String description;
    private boolean isDraft;
    private GitCommitRef lastMergeCommit;
    private GitCommitRef lastMergeSourceCommit;
    private GitCommitRef lastMergeTargetCommit;
    private String mergeId;
    private String mergeStatus;
    private int pullRequestId;
    private Collection<IdentityRefWithVote> reviewers;
    private String sourceRefName;
    private String status;
    private boolean supportsIterations;
    private String targetRefName;
    private String title;
    private String url;

    public Rullrequest() {
        // Empty
    }

    public String getArtifactId() {
        return artifactId;
    }

    public IdentityRef getAutoCompleteSetBy() {
        return autoCompleteSetBy;
    }

    public IdentityRef getClosedBy() {
        return closedBy;
    }

    public OffsetDateTime getClosedDate() {
        return closedDate;
    }

    public int getCodeReviewId() {
        return codeReviewId;
    }

    public Collection<GitCommitRef> getCommits() {
        return commits;
    }

    public GitPullRequestCompletionOptions getCompletionOptions() {
        return completionOptions;
    }

    public OffsetDateTime getCompletionQueueTime() {
        return completionQueueTime;
    }

    public IdentityRef getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public GitCommitRef getLastMergeCommit() {
        return lastMergeCommit;
    }

    public GitCommitRef getLastMergeSourceCommit() {
        return lastMergeSourceCommit;
    }

    public GitCommitRef getLastMergeTargetCommit() {
        return lastMergeTargetCommit;
    }

    public String getMergeId() {
        return mergeId;
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public int getPullRequestId() {
        return pullRequestId;
    }

    public Collection<IdentityRefWithVote> getReviewers() {
        return reviewers;
    }

    public List<IdentityRefWithVote> getSystemReviewers() {
        return reviewers.stream().filter(identity -> !identity.getUniqueName().startsWith("NCDMZ")).collect(Collectors.toList());
    }

    public List<IdentityRefWithVote> getPeopleReviewers() {
        return reviewers.stream().filter(identity -> identity.getUniqueName().startsWith("NCDMZ")).collect(Collectors.toList());
    }

    public String getSourceRefName() {
        return sourceRefName;
    }

    public String getStatus() {
        return status;
    }

    public boolean isSupportsIterations() {
        return supportsIterations;
    }

    public String getTargetRefName() {
        return targetRefName;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
