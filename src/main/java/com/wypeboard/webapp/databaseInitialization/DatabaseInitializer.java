package com.wypeboard.webapp.databaseInitialization;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Bean
    public ApplicationRunner initializeDatabase(DataInitializationService dataInitializationService) {
        return args -> dataInitializationService.initData();
    }
}
