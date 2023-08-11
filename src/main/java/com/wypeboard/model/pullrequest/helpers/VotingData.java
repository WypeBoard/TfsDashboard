package com.wypeboard.model.pullrequest.helpers;

import com.wypeboard.model.pullrequest.type.PullrequestVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VotingData {

    private String reviewerName;
    private boolean pullrequestComplete;
    private PullrequestVote vote;
    private List<String> votedOnBehalfOf = new ArrayList<>();
    private String uniqueName;

    public VotingData() {
        // Empty
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public boolean isPullrequestComplete() {
        return pullrequestComplete;
    }

    public void setPullrequestComplete(boolean pullrequestComplete) {
        this.pullrequestComplete = pullrequestComplete;
    }

    public PullrequestVote getVote() {
        return vote;
    }

    public void setVote(PullrequestVote vote) {
        this.vote = vote;
    }

    public List<String> getVotedOnBehalfOf() {
        return votedOnBehalfOf;
    }

    public void setVotedOnBehalfOf(List<String> votedOnBehalfOf) {
        this.votedOnBehalfOf = votedOnBehalfOf;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.reviewerName, this.pullrequestComplete, this.vote, this.votedOnBehalfOf, this.uniqueName);
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }
}
