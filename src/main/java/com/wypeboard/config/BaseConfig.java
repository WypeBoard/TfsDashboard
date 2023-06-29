package com.wypeboard.config;

import com.wypeboard.adapter.azuredevops.AzureDevOpsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        ControllerConfig.class,
        ServiceConfig.class,
        AzureDevOpsConfig.class
})
public class BaseConfig {
}
