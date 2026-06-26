package com.github.andre10dias.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("greeting-service")
public record GreetingConfiguration(
        String greeting,
        String defaultValue
) {
}
