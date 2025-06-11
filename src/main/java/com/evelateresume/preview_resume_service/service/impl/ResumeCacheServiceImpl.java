package com.evelateresume.preview_resume_service.service.impl;

import com.evelateresume.preview_resume_service.model.ResumeDTO;
import com.evelateresume.preview_resume_service.repository.ResumeRedisRepository;
import com.evelateresume.preview_resume_service.service.ResumeCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeCacheServiceImpl implements ResumeCacheService {

    private final ResumeRedisRepository resumeRedisRepository;

    @Override
    public void cacheResume(ResumeDTO resume) {
        Optional<ResumeDTO> existingResume = resumeRedisRepository.findByUserId(resume.userId());

        existingResume.ifPresent(oldResume -> resumeRedisRepository.deleteById(oldResume.id()));

        resumeRedisRepository.save(resume);
    }

    @Override
    public ResumeDTO getCachedResume(String userId) {
        return resumeRedisRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public void deleteResume(String id) {
        resumeRedisRepository.deleteById(id);
    }
}
