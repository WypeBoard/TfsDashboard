package com.wypeboard.adapter.azuredevops.model.git;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class ThreadsResponse {

    @JsonAlias("value")
    private Collection<Thread> threads;
    private int count;

    public ThreadsResponse() {
        // Empty
    }

    public Collection<Thread> getThreads() {
        return threads;
    }

    public List<Thread> getUserGeneratedThreads() {
        return threads.stream().filter(thread -> thread.getComments().stream().anyMatch(comment -> comment.getParentCommentId() == 0 && !comment.getCommentType().equals("system"))).collect(Collectors.toList());
    }

    public List<Thread> getSystemGeneratedThreads() {
        return threads.stream().filter(thread -> thread.getComments().stream().anyMatch(comment -> comment.getParentCommentId() == 0 && comment.getCommentType().equals("system"))).collect(Collectors.toList());
    }

    public int getCount() {
        return count;
    }
}
