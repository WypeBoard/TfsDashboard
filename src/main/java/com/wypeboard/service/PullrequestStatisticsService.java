package com.wypeboard.service;

public interface PullrequestStatisticsService {
    void calculateStatistics(String gitPath, StringBuilder builder);
}
