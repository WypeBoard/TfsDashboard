package com.wypeboard.controller;

import org.springframework.ui.Model;

public abstract class BaseController {

    protected abstract Page getPageDefinition();

    protected String finalizeModelSetup(Model model) {
        return finalizeModelSetup(model, getPageDefinition());
    }
    protected String finalizeModelSetup(Model model, Page page) {
        model.addAttribute("title", page.getTitle());

        return page.getHtmlfile();
    }

}
