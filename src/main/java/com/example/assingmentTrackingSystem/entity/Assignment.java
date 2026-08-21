package com.example.assingmentTrackingSystem.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;
@Entity
@Table(name = "assignments")
@Data
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Assignment title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;
    @NotBlank(message = "Assignment description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    @Column(columnDefinition = "TEXT")
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
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;
    @NotNull(message = "Teacher is required")
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @ToString.Exclude
    private Teacher teacher;
}