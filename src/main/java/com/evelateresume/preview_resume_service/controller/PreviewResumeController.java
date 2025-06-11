package com.evelateresume.preview_resume_service.controller;

import com.evelateresume.preview_resume_service.model.ResumeDTO;
import com.evelateresume.preview_resume_service.service.impl.ResumeServiceImpl;
import com.evelateresume.preview_resume_service.service.StorageService;
import com.evelateresume.preview_resume_service.util.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preview-resume")
public class PreviewResumeController {

    private final ResumeServiceImpl resumeServiceImpl;
    private final StorageService storageService;
    private final RequestContext requestContext;

    @GetMapping("/user")
    public ResponseEntity<ResumeDTO> get() {
        String userId = requestContext.getUserId();
        ResumeDTO resumeDTO = resumeServiceImpl.getResume(userId);
        if (resumeDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resumeDTO);
    }

    @GetMapping("/user/s3")
    public ResponseEntity<String> getResumeFromS3() throws IOException {
        String userId = requestContext.getUserId();
        ResumeDTO resumeDTO = resumeServiceImpl.getResume(userId);

        String s3Resume = storageService.getLatestVersionOfResume(resumeDTO.s3FileName());

        return ResponseEntity.ok(s3Resume);
    }
}
