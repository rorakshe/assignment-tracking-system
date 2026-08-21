package com.example.assingmentTrackingSystem.repository;

import com.example.assingmentTrackingSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}