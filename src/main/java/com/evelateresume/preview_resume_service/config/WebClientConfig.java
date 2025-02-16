package com.evelateresume.preview_resume_service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final ResumeServiceConfigurationProperties resumeServiceConfigurationProperties;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(resumeServiceConfigurationProperties.getConnectionUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
