package com.example.assingmentTrackingSystem.serviceImpl;

import com.example.assingmentTrackingSystem.dto.SubmissionRequest;
import com.example.assingmentTrackingSystem.dto.SubmissionResponse;
import com.example.assingmentTrackingSystem.entity.Submission;
import com.example.assingmentTrackingSystem.exception.SubmissionNotFoundException;
import com.example.assingmentTrackingSystem.repository.SubmissionRepository;
import com.example.assingmentTrackingSystem.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;


    @Override
    public SubmissionResponse createSubmission(
            SubmissionRequest submissionRequest) {

        Submission submission = new Submission();

        submission.setStudent(submissionRequest.getStudent());
        submission.setAssignment(submissionRequest.getAssignment());
        submission.setSubmittedAt(submissionRequest.getSubmittedAt());
        submission.setScore(submissionRequest.getScore());
        submission.setStatus(submissionRequest.getStatus());
        submission.setFeedback(submissionRequest.getFeedback());

        Submission savedSubmission =
                submissionRepository.save(submission);

        return convertToResponse(savedSubmission);
    }


    @Override
    public List<SubmissionResponse> getAllSubmissions() {

        return submissionRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }


    @Override
    public SubmissionResponse getSubmissionById(Long id) {

        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() ->
                        new SubmissionNotFoundException(
                                "Submission not found with id: " + id
                        ));

        return convertToResponse(submission);
    }


    @Override
    public SubmissionResponse updateSubmission(
            Long id,
            SubmissionRequest submissionRequest) {

        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() ->
                        new SubmissionNotFoundException(
                                "Submission not found with id: " + id
                        ));

        submission.setStudent(submissionRequest.getStudent());
        submission.setAssignment(submissionRequest.getAssignment());
        submission.setSubmittedAt(submissionRequest.getSubmittedAt());
        submission.setScore(submissionRequest.getScore());
        submission.setStatus(submissionRequest.getStatus());
        submission.setFeedback(submissionRequest.getFeedback());

        Submission updatedSubmission =
                submissionRepository.save(submission);

        return convertToResponse(updatedSubmission);
    }


    @Override
    public void deleteSubmission(Long id) {

        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() ->
                        new SubmissionNotFoundException(
                                "Submission not found with id: " + id
                        ));

        submissionRepository.delete(submission);
    }


    private SubmissionResponse convertToResponse(
            Submission submission) {

        SubmissionResponse response = new SubmissionResponse();

        response.setId(submission.getId());
        response.setStudent(submission.getStudent());
        response.setAssignment(submission.getAssignment());
        response.setSubmittedAt(submission.getSubmittedAt());
        response.setScore(submission.getScore());
        response.setStatus(submission.getStatus());
        response.setFeedback(submission.getFeedback());

        return response;
    }
}