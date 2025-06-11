package com.evelateresume.preview_resume_service.repository;

import com.evelateresume.preview_resume_service.model.ResumeDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResumeRedisRepository extends CrudRepository<ResumeDTO, String> {
    Optional<ResumeDTO> findByUserId(String userId);
}
