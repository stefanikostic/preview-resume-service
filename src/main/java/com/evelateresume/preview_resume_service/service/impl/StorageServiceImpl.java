package com.evelateresume.preview_resume_service.service.impl;

import com.evelateresume.preview_resume_service.config.S3ConfigurationProperties;
import com.evelateresume.preview_resume_service.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectVersionsRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final S3Client s3Client;
    private final S3ConfigurationProperties s3ConfigurationProperties;

    @Override
    public String getLatestVersionOfResume(String objectKey) throws IOException {
        String bucketName = s3ConfigurationProperties.getBucketName();
        ListObjectVersionsRequest listObjectVersionsRequest = ListObjectVersionsRequest.builder()
                .bucket(bucketName)
                .prefix(objectKey)
                .build();

       /* ListObjectVersionsResponse listBucketsResponse = s3Client.listObjectVersions(listObjectVersionsRequest);

        List<ObjectVersion> versions = listBucketsResponse.versions();

        ObjectVersion latestVersion = versions.stream()
                .max(Comparator.comparing(ObjectVersion::lastModified)).orElseThrow(S3ObjectNotFoundException::new);
        ResponseInputStream<GetObjectResponse> s3Object = s3Client.getObject(GetObjectRequest.builder().bucket(bucketName)
                .key(objectKey)
                .versionId(latestVersion.versionId()).build());*/

        ResponseInputStream<GetObjectResponse> s3Object = s3Client.getObject(GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build());
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return stringBuilder.toString();
    }
}
