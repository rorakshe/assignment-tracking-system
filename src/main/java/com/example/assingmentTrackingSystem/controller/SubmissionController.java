package com.example.assingmentTrackingSystem.controller;

import com.example.assingmentTrackingSystem.dto.SubmissionRequest;
import com.example.assingmentTrackingSystem.dto.SubmissionResponse;
import com.example.assingmentTrackingSystem.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;


    @PostMapping
    public ResponseEntity<SubmissionResponse> createSubmission(
            @Valid @RequestBody SubmissionRequest submissionRequest) {

        SubmissionResponse response =
                submissionService.createSubmission(submissionRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<SubmissionResponse>> getAllSubmissions() {

        List<SubmissionResponse> submissions =
                submissionService.getAllSubmissions();

        return ResponseEntity.ok(submissions);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SubmissionResponse> getSubmissionById(
            @PathVariable Long id) {

        SubmissionResponse response =
                submissionService.getSubmissionById(id);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubmissionResponse> updateSubmission(
            @PathVariable Long id,
            @Valid @RequestBody SubmissionRequest submissionRequest) {

        SubmissionResponse response =
                submissionService.updateSubmission(id, submissionRequest);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubmission(
            @PathVariable Long id) {

        submissionService.deleteSubmission(id);

        return ResponseEntity.ok("Submission deleted successfully");
    }
}