package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class IdentityRef {

    private String id;
    private String descriptor;
    private String displayName;
    private boolean isDeletedInOrigin;
    private String url;
    private String uniqueName;

    public IdentityRef() {
        // Empty
    }

    public String getId() {
        return id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isDeletedInOrigin() {
        return isDeletedInOrigin;
    }

    public String getUrl() {
        return url;
    }

    public String getUniqueName() {
        return uniqueName;
    }
}
