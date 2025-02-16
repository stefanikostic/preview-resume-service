package com.evelateresume.preview_resume_service.service;

import com.evelateresume.preview_resume_service.client.ResumeServiceClient;
import com.evelateresume.preview_resume_service.entity.Resume;
import com.evelateresume.preview_resume_service.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeServiceClient resumeServiceClient;

    public Resume getResume(String userId) {
        Optional<Resume> cachedResume = resumeRepository.findById(userId);
        if (cachedResume.isPresent()) {
            return cachedResume.get();
        }

        Resume resume = resumeServiceClient.fetchUserResume(userId).block();

        resumeRepository.save(resume);

        return resume;
    }

    public void deleteResume(String userId) {
        resumeRepository.deleteById(userId);
    }
}
