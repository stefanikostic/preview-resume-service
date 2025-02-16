package com.evelateresume.preview_resume_service.entity;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RedisHash(value = "Resume", timeToLive = 3600)
public class Resume {

    private String id;

    @Indexed
    private String userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String title;

    private ResumeTemplate template = ResumeTemplate.ORIGINAL;

    private String fileName;

    private List<Section> sections;

    private String s3FileName;

    private String s3Link;
}
