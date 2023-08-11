package com.wypeboard.model.pullrequest.type;

public enum PullrequestStatus {

    ACTIVE("active"),
    ABANDONED("abandoned"),
    COMPLETED("completed");

    private final String adoStatusText;

    PullrequestStatus(String adoStatusText) {
        this.adoStatusText = adoStatusText;
    }

    public static PullrequestStatus getByAdoValue(String adoValue) {
        for (PullrequestStatus status : values()) {
            if (status.adoStatusText.equals(adoValue)) {
                return status;
            }
        }
        return null;
    }

    public boolean isComplete() {
        return this.equals(COMPLETED);
    }

}
