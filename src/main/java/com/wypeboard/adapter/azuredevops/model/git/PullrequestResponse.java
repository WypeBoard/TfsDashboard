package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Collection;

public class PullrequestResponse {

    @JsonAlias("value")
    private Collection<Rullrequest> pullrequests;
    private int count;

    public PullrequestResponse() {
    }

    public Collection<Rullrequest> getPullrequests() {
        return pullrequests;
    }

    public int getCount() {
        return count;
    }
}
