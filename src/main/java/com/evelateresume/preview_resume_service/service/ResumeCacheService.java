package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.model.ResumeDTO;

public interface ResumeCacheService {
    void cacheResume(ResumeDTO resume);
    ResumeDTO getCachedResume(String userId);
    void deleteResume(String id);
}
