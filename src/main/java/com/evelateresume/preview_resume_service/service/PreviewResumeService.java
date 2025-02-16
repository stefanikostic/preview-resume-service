package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.dto.ResumeDTO;

public interface PreviewResumeService {

    ResumeDTO improveResume();

    ResumeDTO previewResume();
}
