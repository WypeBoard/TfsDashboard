package com.wypeboard.model.pullrequest;

import com.wypeboard.model.pullrequest.helpers.CommentData;
import com.wypeboard.model.pullrequest.helpers.VotingData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PullrequestResult {

    private Map<String, VotingData> userVotingData = new HashMap<>();
    private Map<String, VotingData> requiredSystemVoteData = new HashMap<>();

    private List<CommentData> userStartedComments = new ArrayList<>();
    private List<CommentData> systemStartedComments = new ArrayList<>();

    public Map<String, VotingData> getUserVotingData() {
        return userVotingData;
    }

    public void setUserVotingData(Map<String, VotingData> userVotingData) {
        this.userVotingData = userVotingData;
    }

    public Map<String, VotingData> getRequiredSystemVoteData() {
        return requiredSystemVoteData;
    }

    public void setRequiredSystemVoteData(Map<String, VotingData> requiredSystemVoteData) {
        this.requiredSystemVoteData = requiredSystemVoteData;
    }

    public List<CommentData> getUserStartedComments() {
        return userStartedComments;
    }

    public void setUserStartedComments(List<CommentData> userStartedComments) {
        this.userStartedComments = userStartedComments;
    }

    public List<CommentData> getSystemStartedComments() {
        return systemStartedComments;
    }

    public void setSystemStartedComments(List<CommentData> systemStartedComments) {
        this.systemStartedComments = systemStartedComments;
    }
}
