package com.wypeboard.model.pullrequest.statistics;

import com.wypeboard.adapter.azuredevops.model.git.IdentityRef;
import com.wypeboard.adapter.azuredevops.model.git.IdentityRefWithVote;
import com.wypeboard.model.pullrequest.PullrequestParameter;
import com.wypeboard.model.pullrequest.PullrequestResult;
import com.wypeboard.model.pullrequest.helpers.VotingData;
import com.wypeboard.model.pullrequest.type.PullrequestStatus;
import com.wypeboard.model.pullrequest.type.PullrequestVote;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReviewerVotingStatistics implements Statistics {

    private final List<IdentityRefWithVote> peopleReviewers;
    private final List<IdentityRefWithVote> systemReviewers;
    private final PullrequestStatus status;

    public ReviewerVotingStatistics(PullrequestParameter parameter) {
        this.peopleReviewers = parameter.getPeopleReviewers();
        this.systemReviewers = parameter.getSystemReviewers();
        this.status = parameter.getStatus();
    }

    @Override
    public void calculate(PullrequestResult result) {
        result.getUserVotingData().putAll(peopleReviewers.stream().map(this::fetchIdentityData).collect(Collectors.toMap(VotingData::getUniqueName, Function.identity())));
        result.getRequiredSystemVoteData().putAll(systemReviewers.stream().map(this::fetchIdentityData).collect(Collectors.toMap(VotingData::getUniqueName, Function.identity())));
    }

    private VotingData fetchIdentityData(IdentityRefWithVote identity) {
        VotingData data = new VotingData();
        data.setReviewerName(identity.getDisplayName());
        data.setUniqueName(identity.getUniqueName());
        data.setPullrequestComplete(this.status.isComplete());
        data.setVote(PullrequestVote.getByValue(identity.getVote()));
        List<String> votedOnBehalfOfName = new ArrayList<>();
        identity.getVotedFor().stream().map(IdentityRef::getDisplayName).forEach(votedOnBehalfOfName::add);
        data.setVotedOnBehalfOf(votedOnBehalfOfName);
        return data;
    }
}
