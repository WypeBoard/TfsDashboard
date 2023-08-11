package com.wypeboard.model.pullrequest;

import com.wypeboard.adapter.azuredevops.model.IdentityRefWithVote;
import com.wypeboard.adapter.azuredevops.model.ThreadsResponse;
import com.wypeboard.model.pullrequest.type.PullrequestStatus;

import java.util.ArrayList;
import java.util.List;

public class PullrequestParameter {

    private final int pullrequestId;
    private final String pullRequestName;
    private final PullrequestStatus status;

    private final List<IdentityRefWithVote> peopleReviewers;
    private final List<IdentityRefWithVote> systemReviewers;
    private final ThreadsResponse commentTrack;

    public PullrequestParameter(Builder builder) {
        this.pullrequestId = builder.pullrequestId;
        this.pullRequestName = builder.pullRequestName;
        this.status = builder.status;
        this.peopleReviewers = builder.peopleReviewers;
        this.systemReviewers = builder.systemReviewers;
        this.commentTrack = builder.commentTracks;
    }

    public int getPullrequestId() {
        return pullrequestId;
    }

    public String getPullRequestName() {
        return pullRequestName;
    }

    public PullrequestStatus getStatus() {
        return status;
    }

    public List<IdentityRefWithVote> getPeopleReviewers() {
        return peopleReviewers;
    }

    public List<IdentityRefWithVote> getSystemReviewers() {
        return systemReviewers;
    }

    public ThreadsResponse getCommentTrack() {
        return commentTrack;
    }

    public static class Builder {
        // Required
        private int pullrequestId;
        // Required
        private String pullRequestName;
        // Required
        private PullrequestStatus status;

        public List<IdentityRefWithVote> peopleReviewers;

        public List<IdentityRefWithVote> systemReviewers;
        private ThreadsResponse commentTracks;

        public Builder withPullrequestId(int pullrequestId) {
            this.pullrequestId = pullrequestId;
            return this;
        }

        public Builder withPullRequestName(String pullRequestName) {
            this.pullRequestName = pullRequestName;
            return this;
        }

        public Builder withStatus(PullrequestStatus status) {
            this.status = status;
            return this;
        }

        public Builder withPeopleReviewers(List<IdentityRefWithVote> peopleReviewers) {
            this.peopleReviewers = peopleReviewers;
            return this;
        }

        public Builder withSystemReviewers(List<IdentityRefWithVote> systemReviewers) {
            this.systemReviewers = systemReviewers;
            return this;
        }

        public Builder withCommentTracks(ThreadsResponse threadsResponse) {
            this.commentTracks = threadsResponse;
            return this;
        }

        public PullrequestParameter build() {
            return new PullrequestParameter(this);
        }
    }
}
