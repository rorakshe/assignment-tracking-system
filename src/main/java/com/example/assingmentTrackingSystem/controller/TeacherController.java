package com.example.assingmentTrackingSystem.controller;

import com.example.assingmentTrackingSystem.dto.TeacherRequest;
import com.example.assingmentTrackingSystem.dto.TeacherResponse;
import com.example.assingmentTrackingSystem.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(
            @Valid @RequestBody TeacherRequest teacherRequest) {

        TeacherResponse response =
                teacherService.createTeacher(teacherRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAllTeachers() {

        List<TeacherResponse> teachers =
                teacherService.getAllTeachers();

        return ResponseEntity.ok(teachers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(
            @PathVariable Long id) {

        TeacherResponse response =
                teacherService.getTeacherById(id);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(
            @PathVariable Long id,
            @Valid @RequestBody TeacherRequest teacherRequest) {

        TeacherResponse response =
                teacherService.updateTeacher(id, teacherRequest);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(
            @PathVariable Long id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.ok("Teacher deleted successfully");
    }
}