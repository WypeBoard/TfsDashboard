package com.wypeboard.config;

import com.wypeboard.adapter.azuredevops.AzureDevOpsConfig;
import com.wypeboard.controller.ControllerConfig;
import com.wypeboard.service.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(value = {
        ControllerConfig.class,
        ServiceConfig.class,
        AzureDevOpsConfig.class
})
@PropertySource("classpath:/application.properties")
public class BaseConfig {
}
