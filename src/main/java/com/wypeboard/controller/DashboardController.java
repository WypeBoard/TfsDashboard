package com.wypeboard.controller;

import com.wypeboard.service.PullrequestStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private final PullrequestStatisticsService pullrequestStatisticsService;

    @Autowired
    public DashboardController(PullrequestStatisticsService pullrequestStatisticsService) {
        this.pullrequestStatisticsService = pullrequestStatisticsService;
    }

    @GetMapping(path = "/")
    public String index() {
        return "Hello world";
    }

    @GetMapping(path = "/updateAdo")
    public String updateAdo() {
        StringBuilder builder = new StringBuilder();
        pullrequestStatisticsService.calculateStatistics("refs/heads/ky/dev/5.0-patches", builder);
        pullrequestStatisticsService.calculateStatistics("refs/heads/ky/dev/6.0", builder);
        pullrequestStatisticsService.calculateStatistics("refs/heads/ky/dev/7.1", builder);
        return builder.toString();
    }
}
