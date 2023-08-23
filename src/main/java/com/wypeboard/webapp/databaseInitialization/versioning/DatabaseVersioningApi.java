package com.wypeboard.webapp.databaseInitialization.versioning;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DatabaseVersioningApi {

    void initialize(JdbcTemplate jdbcTemplate);

    boolean isScriptAlreadyExecuted();

    void runScript();
}
