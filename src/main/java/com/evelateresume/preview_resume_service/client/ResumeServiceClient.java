package com.evelateresume.preview_resume_service.client;

import com.evelateresume.preview_resume_service.model.ResumeDTO;
import com.evelateresume.preview_resume_service.util.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ResumeServiceClient {

    private static final String USER_RESUME_PATH = "/internal/resume/user";

    private final WebClient webClient;
    private final RequestContext requestContext;

    public Mono<ResumeDTO> fetchUserResume() {
        return webClient.get()
                .uri(USER_RESUME_PATH)
                .header("Authorization", "Bearer " + requestContext.getJwt())
                .retrieve()
                .bodyToMono(ResumeDTO.class);
    }
}
