package com.example.assingmentTrackingSystem.service;

import com.example.assingmentTrackingSystem.dto.TeacherRequest;
import com.example.assingmentTrackingSystem.dto.TeacherResponse;

import java.util.List;

public interface TeacherService {

    TeacherResponse createTeacher(TeacherRequest teacherRequest);

    List<TeacherResponse> getAllTeachers();

    TeacherResponse getTeacherById(Long id);

    TeacherResponse updateTeacher(
            Long id,
            TeacherRequest teacherRequest
    );

    void deleteTeacher(Long id);
}