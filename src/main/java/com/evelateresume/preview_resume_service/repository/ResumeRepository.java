package com.evelateresume.preview_resume_service.repository;

import com.evelateresume.preview_resume_service.entity.Resume;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResumeRepository extends CrudRepository<Resume, String> {
    Optional<Resume> findByUserId(String userId);
}
