package com.example.assingmentTrackingSystem.dto;

import com.example.assingmentTrackingSystem.entity.AssignmentStatus;
import com.example.assingmentTrackingSystem.entity.Teacher;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentRequest {

    @NotBlank(message = "Assignment title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Assignment description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;


    @NotBlank(message = "Subject is required")
    private String subject;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;

    @NotNull(message = "Maximum marks are required")
    @Positive(message = "Maximum marks must be greater than 0")
    private Double maxMarks;

    @NotNull(message = "Assignment status is required")
    private AssignmentStatus status;

    @NotNull(message = "Teacher is required")
    private Teacher teacher;
}