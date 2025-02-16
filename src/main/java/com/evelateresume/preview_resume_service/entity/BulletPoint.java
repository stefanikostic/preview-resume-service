package com.evelateresume.preview_resume_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BulletPoint {

    private Long id;

    private String title;

    private String content;

    private String improvedContent;

    private Boolean isImprovementApproved = false;

    private Section section;
}
