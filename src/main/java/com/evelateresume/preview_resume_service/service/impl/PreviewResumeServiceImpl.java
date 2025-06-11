package com.evelateresume.preview_resume_service.service.impl;

import com.evelateresume.preview_resume_service.client.ResumeServiceClient;
import com.evelateresume.preview_resume_service.model.ResumeDTO;
import com.evelateresume.preview_resume_service.service.PreviewResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreviewResumeServiceImpl implements PreviewResumeService {

    private final ResumeServiceClient resumeServiceClient;

    @Override
    public ResumeDTO improveResume() {
        ResumeDTO resume = resumeServiceClient.fetchUserResume().block();
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
