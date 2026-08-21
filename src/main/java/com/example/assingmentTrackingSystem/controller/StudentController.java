package com.example.assingmentTrackingSystem.controller;

import com.example.assingmentTrackingSystem.dto.StudentRequest;
import com.example.assingmentTrackingSystem.dto.StudentResponse;
import com.example.assingmentTrackingSystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(
            @Valid @RequestBody StudentRequest studentRequest) {

        StudentResponse response =
                studentService.createStudent(studentRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {

        List<StudentResponse> students =
                studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(
            @PathVariable Long id) {

        StudentResponse response =
                studentService.getStudentById(id);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest studentRequest) {

        StudentResponse response =
                studentService.updateStudent(id, studentRequest);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully");
    }
}