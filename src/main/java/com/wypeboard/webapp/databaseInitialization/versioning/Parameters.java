package com.wypeboard.webapp.databaseInitialization.versioning;

import org.springframework.jdbc.core.JdbcTemplate;

public class Parameters implements DatabaseVersioningApi {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void initialize(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void runScript() {
        createParametertype();
        createParameterattribute();
        createParameterinstance();
        createParametervalue();
    }

    private void createParametertype() {
        String createTableQuery = "CREATE TABLE PARAMETERTYPE (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "NAME VARCHAR(500)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }

    private void createParameterattribute() {
        String createTableQuery = "CREATE TABLE PARAMETERATTRIBUTE (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "PARAMETERTYPE_ID VARCHAR(36)",
                "NAME VARCHAR(500)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }

    private void createParameterinstance() {
        String createTableQuery = "CREATE TABLE PARAMETERINSTANCE (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "PARAMETERTYPE_ID VARCHAR(36)",
                "INSTANCE VARCHAR(500)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }

    private void createParametervalue() {
        String createTableQuery = "CREATE TABLE PARAMETERVALUE (" + String.join(", ",
                "ID VARCHAR(36) PRIMARY KEY",
                "PARAMETERINSTANS_ID VARCHAR(36)",
                "PARAMETERATTRIBUTE_ID VARCHAR(36)",
                "VALUE VARCHAR(500)",
                "CREATED_BY VARCHAR(500)",
                "CREATED TIMESTAMP",
                "CHANGED_BY VARCHAR(500)",
                "CHANGED TIMESTAMP);");
        jdbcTemplate.execute(createTableQuery);
    }
}
