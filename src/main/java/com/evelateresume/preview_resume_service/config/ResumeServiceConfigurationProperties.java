package com.evelateresume.preview_resume_service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("resume-service")
@Getter
@Setter
public class ResumeServiceConfigurationProperties {
    private String connectionUrl;
}
