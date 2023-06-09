package com.wypeboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        ControllerConfig.class
})
public class BaseConfig {
}
