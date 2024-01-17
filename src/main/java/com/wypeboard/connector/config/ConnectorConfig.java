package com.wypeboard.connector.config;

import com.wypeboard.connector.database.DatabaseConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        DatabaseConfig.class,
})
public class ConnectorConfig {
}
