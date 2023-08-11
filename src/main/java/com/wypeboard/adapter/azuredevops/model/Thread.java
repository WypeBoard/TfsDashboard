package com.wypeboard.adapter.azuredevops.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class Thread {

    private String id;
    private Collection<Comment> comments;
    private Map<String, IdentityRef> identities;
    private boolean isDeleted;
    private OffsetDateTime lastUpdatedDate;
    private OffsetDateTime publishedDate;
    private String status;
    private CommentThreadContext threadContext;

    public Thread() {
        // Empty
    }

    public String getId() {
        return id;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Map<String, IdentityRef> getIdentities() {
        return identities;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public OffsetDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public OffsetDateTime getPublishedDate() {
        return publishedDate;
    }

    public String getStatus() {
        return status;
    }

    public CommentThreadContext getThreadContext() {
        return threadContext;
    }
}
