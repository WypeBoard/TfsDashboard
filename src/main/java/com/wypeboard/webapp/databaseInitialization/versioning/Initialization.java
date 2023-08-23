package com.wypeboard.webapp.databaseInitialization.versioning;

import org.springframework.jdbc.core.JdbcTemplate;

public class Initialization implements DatabaseVersioningApi {

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
        String createTableQuery = String.join(" ", "CREATE TABLE IF NOT EXISTS VERSIONING (",
                "ID VARCHAR(36) PRIMARY KEY,",
                "EXECUTED_METHOD VARCHAR(500),",
                "STATUS VARCHAR(50)",
                "CREATEDBY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "ALTEREDBY VARCHAR(500)",
                "ALTERED TIMESTAMP",
                ")");
        jdbcTemplate.execute(createTableQuery);
    }

}
