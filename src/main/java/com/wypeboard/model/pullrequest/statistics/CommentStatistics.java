package com.wypeboard.model.pullrequest.statistics;

import com.wypeboard.adapter.azuredevops.model.Comment;
import com.wypeboard.adapter.azuredevops.model.Thread;
import com.wypeboard.model.pullrequest.PullrequestParameter;
import com.wypeboard.model.pullrequest.PullrequestResult;
import com.wypeboard.model.pullrequest.helpers.CommentData;
import com.wypeboard.model.pullrequest.helpers.VotingData;
import com.wypeboard.model.pullrequest.type.PullrequestStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentStatistics implements Statistics {

    private static final String CHMM_JAVADOC_AUTOMATOR = "Project Collection Build Service (Netcompany)";
    public static final String CHMM_JAVA_DOCTOR = "CHMM JavaDocter";
    private static final String SONARQUBE_USER = "su-netc-tfs-egn0004";
    private static final String SONAR_QUBE = "SonarQube";
    private final List<Thread> userStartedComments;
    private final PullrequestStatus status;

    public CommentStatistics(PullrequestParameter parameter) {
        this.userStartedComments = parameter.getCommentTrack().getUserGeneratedThreads();
        this.status = parameter.getStatus();
    }

    @Override
    public void calculate(PullrequestResult result) {
        if (userStartedComments == null) {
            System.out.println("FUCK");
        }
        result.getUserStartedComments().addAll(userStartedComments.stream().map(this::fetchUserCommentData).collect(Collectors.toList()));
    }

    private CommentData fetchUserCommentData(Thread thread) {
        CommentData data = new CommentData();
        // Get the number of comments in the thread
        data.setNumbersOfComments(thread.getComments().size());
        // Who has commented on the thread
        Map<String, Integer> userCommentCountInThread = new HashMap<>();
        for (Comment comment : thread.getComments()) {
            String displayName = comment.getAuthor().getDisplayName();
            if (CHMM_JAVADOC_AUTOMATOR.equals(displayName)) {
                displayName = CHMM_JAVA_DOCTOR;
            } else if (SONARQUBE_USER.equals(displayName)) {
                displayName = SONAR_QUBE;

            }
            userCommentCountInThread.putIfAbsent(displayName, 0);
            userCommentCountInThread.compute(displayName, (k, v) -> v + 1);
        }
        data.setUserCommentCount(userCommentCountInThread);
        return data;

    }
}
