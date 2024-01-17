package com.wypeboard.controller;

public enum Page {
    DASHBOARD("index.html","Frontpage"),
    CONFIGURATION("configuration.html","Configuration"),
    TEST("test.html","Test");

    private final String htmlfile;
    private final String title;

    Page(String htmlfile, String title) {
        this.htmlfile = htmlfile;
        this.title = title;
    }

    public String getHtmlfile() {
        return htmlfile;
    }

    public String getTitle() {
        return title;
    }
}
