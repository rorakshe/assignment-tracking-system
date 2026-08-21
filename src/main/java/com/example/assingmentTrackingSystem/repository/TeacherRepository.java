package com.example.assingmentTrackingSystem.repository;
import com.example.assingmentTrackingSystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
