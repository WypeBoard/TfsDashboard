package com.wypeboard.adapter.azuredevops.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class Comment {

    private Integer id;
    private IdentityRef author;
    private Integer parentCommentId;
    private String content;
    private String commentType;

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public IdentityRef getAuthor() {
        return author;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public String getContent() {
        return content;
    }

    public String getCommentType() {
        return commentType;
    }
}
