package com.wypeboard.model.pullrequest.type;

public enum PullrequestVote {
     APPROVED(10),
     APPROVED_WITH_SUGGESTIONS(5),
     NO_VOTE(0),
     WAITING_FOR_AUTHOR(-5),
     REJECTED(-10);

     private final int voteValue;

    PullrequestVote(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public static PullrequestVote getByValue(int voteValue) {
        for (PullrequestVote vote : values()) {
            if (vote.getVoteValue() == voteValue) {
                return vote;
            }
        }
        return null;
    }


}
