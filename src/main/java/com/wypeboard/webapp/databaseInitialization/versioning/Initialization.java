package com.wypeboard.webapp.databaseInitialization.versioning;

import org.springframework.jdbc.core.JdbcTemplate;

public class Initialization implements DatabaseVersioningApi {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void initialize(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void runScript() {
        createVersioning();
        createConfiguration();
    }

    private void createConfiguration() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS CONFIGURATION (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "TYPE VARCHAR(500)",
                "NAME VARCHAR(50)",
                "CONFIG_VALUE VARCHAR(50)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }

    private void createVersioning() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS VERSIONING (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "EXECUTED_METHOD VARCHAR(500)",
                "STATUS VARCHAR(50)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }

}
