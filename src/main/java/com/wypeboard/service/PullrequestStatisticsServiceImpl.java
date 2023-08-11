package com.wypeboard.service;

import com.wypeboard.adapter.azuredevops.AzureClient;
import com.wypeboard.adapter.azuredevops.AzureFilters;
import com.wypeboard.adapter.azuredevops.model.PullrequestResponse;
import com.wypeboard.adapter.azuredevops.model.ThreadsResponse;
import com.wypeboard.model.pullrequest.PullrequestCalculation;
import com.wypeboard.model.pullrequest.PullrequestParameter;
import com.wypeboard.model.pullrequest.PullrequestResult;
import com.wypeboard.model.pullrequest.helpers.CommentData;
import com.wypeboard.model.pullrequest.helpers.VotingData;
import com.wypeboard.model.pullrequest.type.PullrequestStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PullrequestStatisticsServiceImpl implements PullrequestStatisticsService {

    @Override
    public void calculateStatistics(String gitPath, StringBuilder builder) {
        PullrequestResponse pullrequestResponse = new AzureClient().addFilter(AzureFilters.SEARCH_TARGET_REF, gitPath)
                .addFilter(AzureFilters.SEARCH_CRITERIA_STATAUS, "all")
                .addFilter(AzureFilters.SEARCH_CRITERIA_TOP, "1000")
                .fetchPullRequest();
        List<PullrequestResult> pullrequestResultList = new ArrayList<>();
        pullrequestResponse.getPullrequests().forEach(pullrequest -> {
            ThreadsResponse threadsResponse = new AzureClient().fetchPullRequestThreads(pullrequest.getPullRequestId());
            PullrequestParameter parameter = new PullrequestParameter.Builder().withPullrequestId(pullrequest.getPullRequestId())
                    .withPullRequestName(pullrequest.getTitle())
                    .withStatus(PullrequestStatus.getByAdoValue(pullrequest.getStatus()))
                    .withPeopleReviewers(pullrequest.getPeopleReviewers())
                    .withSystemReviewers(pullrequest.getSystemReviewers())
                    .withCommentTracks(threadsResponse)
                    .build();

            PullrequestCalculation pullrequestData = new PullrequestCalculation(parameter);
            pullrequestResultList.add(pullrequestData.calculate());
        });
        // Testing only!
        System.out.println("Comment count " + gitPath);
        Map<String, Integer> collect = pullrequestResultList.stream()
                .map(PullrequestResult::getUserStartedComments)
                .flatMap(Collection::stream)
                .map(CommentData::getUserCommentCount)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
        Map<String, Integer> collect1 = pullrequestResultList.stream()
                .map(PullrequestResult::getRequiredSystemVoteData)
                .map(Map::values)
                .flatMap(Collection::stream)
                .map(VotingData::getReviewerName)
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        Map<String, Integer> collect2 = pullrequestResultList.stream()
                .map(PullrequestResult::getUserVotingData)
                .map(Map::values)
                .flatMap(Collection::stream)
                .map(VotingData::getReviewerName)
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        builder.append("<h1>").append(gitPath).append("</h1>");
        builder.append("Number of pullrequests: ").append(pullrequestResultList.size()).append("<br/>");
        builder.append("<h2>Comment count</h2><br/>");
        collect.forEach((user, count) -> builder.append(user).append(":").append(count).append("<br/>"));
        builder.append("<h2>review groups</h2><br/>");
        collect1.forEach((reviewGroup, count) -> builder.append(reviewGroup).append(":").append(count).append("<br/>"));
        builder.append("<h2>user voting</h2><br/>");
        collect2.forEach((userVoting, count) -> builder.append(userVoting).append(":").append(count).append("<br/>"));
        builder.append("<br/><br/>");
    }
}
