package com.evelateresume.preview_resume_service.service.impl;

import com.evelateresume.preview_resume_service.client.ResumeServiceClient;
import com.evelateresume.preview_resume_service.model.ResumeDTO;
import com.evelateresume.preview_resume_service.repository.ResumeRedisRepository;
import com.evelateresume.preview_resume_service.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRedisRepository resumeRedisRepository;
    private final ResumeServiceClient resumeServiceClient;

    @Override
    public ResumeDTO getResume(String userId) {
        Optional<ResumeDTO> cachedResume = resumeRedisRepository.findByUserId(userId);
        if (cachedResume.isPresent()) {
            return cachedResume.get();
        }

        ResumeDTO resume = resumeServiceClient.fetchUserResume().block();

        resumeRedisRepository.save(resume);

        return resume;
    }

    @Override
    public void deleteResume(String userId) {
        resumeRedisRepository.deleteById(userId);
    }
}
