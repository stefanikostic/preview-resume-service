package com.evelateresume.preview_resume_service.model;

public record BulletPointDTO(String id, String title, String content, String improvedContent,
                             boolean isImprovementApproved) {
}