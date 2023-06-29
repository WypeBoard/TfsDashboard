package com.wypeboard.controller;

import com.wypeboard.adapter.azuredevops.AzureClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping(path = "/")
    public String index() {
        return "Hello world";
    }

    @GetMapping(path = "/updateAdo")
    public String updateAdo() {
        new AzureClient();
    }
}
