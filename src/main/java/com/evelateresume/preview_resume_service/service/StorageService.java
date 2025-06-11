package com.evelateresume.preview_resume_service.service;

import java.io.IOException;

public interface StorageService {
    String getLatestVersionOfResume(String objectKey) throws IOException;
}
