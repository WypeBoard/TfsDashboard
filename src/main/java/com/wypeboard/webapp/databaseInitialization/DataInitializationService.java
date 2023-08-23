package com.wypeboard.webapp.databaseInitialization;

import com.wypeboard.webapp.databaseInitialization.versioning.DatabaseVersioningApi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataInitializationService {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializationService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initData() {
        for(DatabaseVersioning databaseVersioning : DatabaseVersioning.values()) {
            DatabaseVersioningApi versioningApi = databaseVersioning.getVersioning();
            versioningApi.initialize(jdbcTemplate);
            if (versioningApi.isScriptAlreadyExecuted()) {
                continue;
            }
            versioningApi.runScript();
        }
    }
}
