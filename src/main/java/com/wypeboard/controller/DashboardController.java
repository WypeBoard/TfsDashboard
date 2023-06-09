package com.wypeboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping(path = "/")
    public String index() {
        return "Hello world";
    }
}
