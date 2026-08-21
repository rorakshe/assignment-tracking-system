package com.example.assingmentTrackingSystem.repository;
import com.example.assingmentTrackingSystem.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SubmissionRepository  extends JpaRepository<Submission, Long> {
}
