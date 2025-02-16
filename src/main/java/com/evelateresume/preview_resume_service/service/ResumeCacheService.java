package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.entity.Resume;
import com.evelateresume.preview_resume_service.repository.ResumeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeCacheService {

    private final ResumeRepository resumeRepository;

    public void cacheResume(Resume resume) {
        Optional<Resume> existingResume = resumeRepository.findByUserId(resume.getUserId());

        existingResume.ifPresent(oldResume -> resumeRepository.deleteById(oldResume.getId()));

        resumeRepository.save(resume);
    }

    public Resume getCachedResume(String userId) {
        return resumeRepository.findByUserId(userId).orElse(null);
    }

    public void deleteResume(String id) {
        resumeRepository.deleteById(id);
    }
}
