package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.model.ResumeDTO;

public interface ResumeService {
    ResumeDTO getResume(String userId);
    void deleteResume(String userId);
}
