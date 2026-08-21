package com.example.assingmentTrackingSystem.dto;

import com.example.assingmentTrackingSystem.entity.Assignment;
import com.example.assingmentTrackingSystem.entity.Student;
import com.example.assingmentTrackingSystem.entity.SubmissionStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubmissionResponse {

    private Long id;
    private Student student;
    private Assignment assignment;
    private LocalDateTime submittedAt;
    private Double score;
    private SubmissionStatus status;
    private String feedback;
}