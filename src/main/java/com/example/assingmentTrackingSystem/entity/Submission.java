package com.example.assingmentTrackingSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student is required")
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @ToString.Exclude
    private Student student;

    @NotNull(message = "Assignment is required")
    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    @ToString.Exclude
    private Assignment assignment;

    private LocalDateTime submittedAt;

    @PositiveOrZero(message = "Score cannot be negative")
    private Double score;

    @NotNull(message = "Submission status is required")
    @Enumerated(EnumType.STRING)
    private SubmissionStatus status;

    @Size(max = 1000, message = "Feedback cannot exceed 1000 characters")
    @Column(columnDefinition = "TEXT")
    private String feedback;
}