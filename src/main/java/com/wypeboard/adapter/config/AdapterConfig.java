package com.wypeboard.adapter.config;

import com.wypeboard.adapter.azuredevops.AzureDevOpsConfig;
import com.wypeboard.adapter.database.DbAdapterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        AzureDevOpsConfig.class,
        DbAdapterConfig.class
})

public class AdapterConfig {
}
