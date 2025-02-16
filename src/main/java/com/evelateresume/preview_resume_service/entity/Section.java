package com.evelateresume.preview_resume_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Section {

    private Long id;

    private String title;

    private SectionType type;

    private String content;

    private Integer sectionOrder;

    private boolean isOptional;

    private List<BulletPoint> bulletPoints;

    private String startPeriod;

    private String endPeriod;
}
