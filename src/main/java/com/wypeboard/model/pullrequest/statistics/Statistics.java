package com.wypeboard.model.pullrequest.statistics;

import com.wypeboard.model.pullrequest.PullrequestResult;

public interface Statistics {

    void calculate(PullrequestResult result);
}
