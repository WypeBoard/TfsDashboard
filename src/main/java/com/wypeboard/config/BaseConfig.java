package com.wypeboard.config;

import com.wypeboard.adapter.config.AdapterConfig;
import com.wypeboard.connector.config.ConnectorConfig;
import com.wypeboard.controller.ControllerConfig;
import com.wypeboard.repository.config.RepositoryConfig;
import com.wypeboard.service.config.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(value = {
        ControllerConfig.class,
        ServiceConfig.class,
        AdapterConfig.class,
        ConnectorConfig.class,
        RepositoryConfig.class,
})
@PropertySource("classpath:/application.properties")
public class BaseConfig {
}
