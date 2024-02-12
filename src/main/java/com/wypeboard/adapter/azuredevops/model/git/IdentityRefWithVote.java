package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class IdentityRefWithVote extends IdentityRef {

    private boolean hasDeclined;
    private boolean isContainer;
    private boolean isFlagged;
    private boolean isRequired;
    /**
     *  10: approved
     *  5: approved with suggestions
     *  0: no vote
     *  -5: waiting for author
     *  -10: rejected
     */
    private int vote;
    private Collection<IdentityRefWithVote> votedFor;

    public IdentityRefWithVote() {
        // Empty
    }

    public boolean isHasDeclined() {
        return hasDeclined;
    }

    public boolean isContainer() {
        return isContainer;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public int getVote() {
        return vote;
    }

    public Collection<IdentityRefWithVote> getVotedFor() {
        if (votedFor == null) {
            return new ArrayList<>();
        }
        return votedFor;
    }
}
