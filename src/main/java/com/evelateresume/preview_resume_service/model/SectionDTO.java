package com.evelateresume.preview_resume_service.model;

import java.util.List;

public record SectionDTO(String id, String title, SectionType type, String content, Integer sectionOrder, boolean isOptional,
                         List<BulletPointDTO> bulletPointModelList, String startPeriod, String endPeriod) {
}