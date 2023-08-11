package com.wypeboard.model.pullrequest.helpers;

import java.util.Map;

public class CommentData {

    private int numbersOfComments;
    private Map<String, Integer> userCommentCount;

    public void setNumbersOfComments(int numbersOfComments) {
        this.numbersOfComments = numbersOfComments;
    }

    public int getNumbersOfComments() {
        return numbersOfComments;
    }

    public void setUserCommentCount(Map<String, Integer> userCommentCount) {
        this.userCommentCount = userCommentCount;
    }

    public Map<String, Integer> getUserCommentCount() {
        return userCommentCount;
    }
}
