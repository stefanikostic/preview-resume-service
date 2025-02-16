package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.client.ResumeServiceClient;
import com.evelateresume.preview_resume_service.dto.ResumeDTO;
import com.evelateresume.preview_resume_service.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PreviewResumeServiceImpl implements PreviewResumeService {

    private final ResumeServiceClient resumeServiceClient;

    @Override
    public ResumeDTO improveResume() {
        Resume resume = resumeServiceClient.fetchUserResume("userId").block();
        // send to resume processor to improve resume
        // store in cache in Redis
        // return improved resume

        return null;
    }

    @Override
    public ResumeDTO previewResume() {
        return null;
    }
}
