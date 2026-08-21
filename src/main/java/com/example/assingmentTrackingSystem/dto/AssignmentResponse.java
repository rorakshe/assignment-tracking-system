package com.example.assingmentTrackingSystem.dto;

import com.example.assingmentTrackingSystem.entity.AssignmentStatus;
import com.example.assingmentTrackingSystem.entity.Teacher;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentResponse {

    private Long id;
    private String title;
    private String description;
    private String subject;
    private LocalDate dueDate;
    private Double maxMarks;
    private AssignmentStatus status;
    private Teacher teacher;
}