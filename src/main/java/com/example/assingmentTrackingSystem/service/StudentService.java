package com.example.assingmentTrackingSystem.service;

import com.example.assingmentTrackingSystem.dto.StudentRequest;
import com.example.assingmentTrackingSystem.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);

    void deleteStudent(Long id);
}