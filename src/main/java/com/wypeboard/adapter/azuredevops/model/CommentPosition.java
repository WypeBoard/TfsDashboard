package com.wypeboard.adapter.azuredevops.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class CommentPosition {

    private int line;
    private int offset;

    public CommentPosition() {
        // Empty
    }

    public int getLine() {
        return line;
    }

    public int getOffset() {
        return offset;
    }
}
