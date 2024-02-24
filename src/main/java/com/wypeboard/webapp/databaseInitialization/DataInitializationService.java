package com.wypeboard.webapp.databaseInitialization;

import com.wypeboard.webapp.databaseInitialization.versioning.DatabaseVersioningApi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataInitializationService {

    private final JdbcTemplate jdbcTemplate;

    public DataInitializationService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initData() {
        /*for (DatabaseVersioning databaseVersioning : DatabaseVersioning.values()) {
            DatabaseVersioningApi versioningApi = databaseVersioning.getVersioning();
            if (isVersioningExecuted(databaseVersioning.name())) {
                continue;
            }
            versioningApi.initialize(jdbcTemplate);
            versioningApi.runScript();
            registerExecution(databaseVersioning.name());
        }*/
    }

    private void registerExecution(String name) {
        String sql = "INSERT INTO VERSIONING (ID, EXECUTED_METHOD, STATUS, CREATED_BY, CREATED, CHANGED_BY, CHANGED) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                UUID.randomUUID().toString(),
                name,
                "EXECUTED",
                "SYSTEM",
                LocalDateTime.now(),
                "SYSTEM",
                LocalDateTime.now()
        );
    }

    private boolean isVersioningExecuted(String databaseVersioning) {
        String sql = "Select count(id) from VERSIONING WHERE EXECUTED_METHOD = ?";
        Integer resultQuery = jdbcTemplate.queryForObject(sql, Integer.class, databaseVersioning);
        return resultQuery != null && resultQuery > 0;
    }
}
