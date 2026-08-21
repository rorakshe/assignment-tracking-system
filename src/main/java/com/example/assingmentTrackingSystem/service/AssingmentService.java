package com.example.assingmentTrackingSystem.service;
import com.example.assingmentTrackingSystem.dto.AssignmentRequest;
import com.example.assingmentTrackingSystem.dto.AssignmentResponse;
import java.util.List;
public interface AssingmentService {
    AssignmentResponse createAssignment(AssignmentRequest assignmentRequest);
    List<AssignmentResponse> getAllAssignments();
    AssignmentResponse getAssignmentById(Long id);
    AssignmentResponse updateAssignment(Long id, AssignmentRequest assignmentRequest);
    void deleteAssignment(Long id);
}