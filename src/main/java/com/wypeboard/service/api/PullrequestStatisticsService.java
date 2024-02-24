package com.wypeboard.service.api;

public interface PullrequestStatisticsService {
    void calculateStatistics(String gitPath, StringBuilder builder);
}
