package com.wypeboard.controller;

import com.wypeboard.service.PullrequestStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TempDashboard extends BaseController {

    private final PullrequestStatisticsService pullrequestStatisticsService;

    public static final List<String> fetchTargetBranch = List.of(
            "refs/heads/ky/dev/5.0-patches",
            "refs/heads/ky/dev/6.0-patches",
            "refs/heads/ky/dev/6.0",
            "refs/heads/ky/dev/6.1",
            "refs/heads/ky/dev/7.0",
            "refs/heads/ky/dev/7.1"
    );

    @Autowired
    public TempDashboard(PullrequestStatisticsService pullrequestStatisticsService) {
        this.pullrequestStatisticsService = pullrequestStatisticsService;
    }

    @Override
    protected Page getPageDefinition() {
        return null;
    }

    @GetMapping(path = "/updateAdo")
    public String updateAdo() {
        StringBuilder builder = new StringBuilder();
        fetchTargetBranch.forEach(targetBranch -> pullrequestStatisticsService.calculateStatistics(targetBranch, builder));
        return builder.toString();
    }

}
