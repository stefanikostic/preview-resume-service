package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.model.ResumeDTO;

public interface PreviewResumeService {

    ResumeDTO improveResume();

    ResumeDTO previewResume();
}
