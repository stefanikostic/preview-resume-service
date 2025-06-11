package com.evelateresume.preview_resume_service.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Getter
@Setter
public class RequestContext {
    private String userId;
    private String jwt;
}
