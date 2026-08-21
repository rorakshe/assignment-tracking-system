package com.example.assingmentTrackingSystem.controller;

import com.example.assingmentTrackingSystem.dto.AssignmentRequest;
import com.example.assingmentTrackingSystem.dto.AssignmentResponse;
import com.example.assingmentTrackingSystem.service.AssingmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssingmentService assingmentService;


    @PostMapping
    public ResponseEntity<AssignmentResponse> createAssignment(
            @Valid @RequestBody AssignmentRequest assignmentRequest) {

        AssignmentResponse response =
                assingmentService.createAssignment(assignmentRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<AssignmentResponse>> getAllAssignments() {

        List<AssignmentResponse> assignments =
                assingmentService.getAllAssignments();

        return ResponseEntity.ok(assignments);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AssignmentResponse> getAssignmentById(
            @PathVariable Long id) {

        AssignmentResponse response =
                assingmentService.getAssignmentById(id);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @Valid @RequestBody AssignmentRequest assignmentRequest) {

        AssignmentResponse response =
                assingmentService.updateAssignment(id, assignmentRequest);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(
            @PathVariable Long id) {

        assingmentService.deleteAssignment(id);

        return ResponseEntity.ok("Assignment deleted successfully");
    }
}