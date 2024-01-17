package com.wypeboard.model.pullrequest;

import com.wypeboard.model.pullrequest.statistics.ByPassedStatistics;
import com.wypeboard.model.pullrequest.statistics.CommentStatistics;
import com.wypeboard.model.pullrequest.statistics.ReviewerVotingStatistics;

public class PullrequestCalculation {

    private final ReviewerVotingStatistics reviewerVotingStatistics;
    private final CommentStatistics commentStatistics;
    private final ByPassedStatistics byPassedStatistics;

    public PullrequestCalculation(PullrequestParameter parameter) {
        this.reviewerVotingStatistics = new ReviewerVotingStatistics(parameter);
        this.commentStatistics = new CommentStatistics(parameter);
        this.byPassedStatistics = new ByPassedStatistics(parameter);
    }


    public PullrequestResult calculate() {
        PullrequestResult result = new PullrequestResult();
        reviewerVotingStatistics.calculate(result);
        commentStatistics.calculate(result);
        return result;
    }
}
