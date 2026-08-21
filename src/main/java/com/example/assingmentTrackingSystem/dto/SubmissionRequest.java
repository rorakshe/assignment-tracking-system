package com.example.assingmentTrackingSystem.dto;

import com.example.assingmentTrackingSystem.entity.Assignment;
import com.example.assingmentTrackingSystem.entity.Student;
import com.example.assingmentTrackingSystem.entity.SubmissionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubmissionRequest {

    @NotNull(message = "Student is required")
    private Student student;

    @NotNull(message = "Assignment is required")
    private Assignment assignment;

    private LocalDateTime submittedAt;

    @PositiveOrZero(message = "Score cannot be negative")
    private Double score;

    @NotNull(message = "Submission status is required")
    private SubmissionStatus status;

    @Size(max = 1000, message = "Feedback cannot exceed 1000 characters")
    private String feedback;
}