package com.wypeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController extends BaseController {

    @Override
    protected Page getPageDefinition() {
        return Page.DASHBOARD;
    }

    @GetMapping(path = "/")
    public String index(Model model) {
        return finalizeModelSetup(model);
    }

}
