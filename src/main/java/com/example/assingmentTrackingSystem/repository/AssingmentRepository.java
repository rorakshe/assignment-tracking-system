package com.example.assingmentTrackingSystem.repository;
import com.example.assingmentTrackingSystem.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AssingmentRepository  extends JpaRepository<Assignment, Long> {
}
