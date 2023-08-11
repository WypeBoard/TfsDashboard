package com.wypeboard.adapter.azuredevops.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class CommentThreadContext {

    private String filePath;
    private CommentPosition leftFileStart;
    private CommentPosition leftFileEnd;
    private CommentPosition rightFileStart;
    private CommentPosition rightFileEnd;

    public CommentThreadContext() {
        // Empty
    }

    public String getFilePath() {
        return filePath;
    }

    public CommentPosition getLeftFileStart() {
        return leftFileStart;
    }

    public CommentPosition getLeftFileEnd() {
        return leftFileEnd;
    }

    public CommentPosition getRightFileStart() {
        return rightFileStart;
    }

    public CommentPosition getRightFileEnd() {
        return rightFileEnd;
    }
}
