package com.evelateresume.preview_resume_service.client;

import com.evelateresume.preview_resume_service.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ResumeServiceClient {

    private static final String USER_RESUME_PATH = "/resume/user/";

    private final WebClient webClient;

    public Mono<Resume> fetchUserResume(String userId) {
        return webClient.get()
                .uri(USER_RESUME_PATH + userId)
                .retrieve()
                .bodyToMono(Resume.class);
    }
}
