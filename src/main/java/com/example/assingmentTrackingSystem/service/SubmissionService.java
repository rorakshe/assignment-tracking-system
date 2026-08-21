package com.example.assingmentTrackingSystem.service;

import com.example.assingmentTrackingSystem.dto.SubmissionRequest;
import com.example.assingmentTrackingSystem.dto.SubmissionResponse;

import java.util.List;

public interface SubmissionService {

    SubmissionResponse createSubmission(SubmissionRequest submissionRequest);

    List<SubmissionResponse> getAllSubmissions();

    SubmissionResponse getSubmissionById(Long id);

    SubmissionResponse updateSubmission(
            Long id,
            SubmissionRequest submissionRequest
    );

    void deleteSubmission(Long id);
}