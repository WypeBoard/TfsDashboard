package com.wypeboard.webapp.databaseInitialization.versioning;

import org.springframework.jdbc.core.JdbcTemplate;

public class ConfigurationVersioning implements DatabaseVersioningApi {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void initialize(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isScriptAlreadyExecuted() {
        return false;
    }

    @Override
    public void runScript() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS CONFIGURATION (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "TYPE VARCHAR(500)",
                "NAME VARCHAR(50)",
                "VALUE VARCHAR(50)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }
}
