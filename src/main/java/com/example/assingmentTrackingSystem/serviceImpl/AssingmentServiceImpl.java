package com.example.assingmentTrackingSystem.serviceImpl;

import com.example.assingmentTrackingSystem.dto.AssignmentRequest;
import com.example.assingmentTrackingSystem.dto.AssignmentResponse;
import com.example.assingmentTrackingSystem.entity.Assignment;
import com.example.assingmentTrackingSystem.exception.AssignmentNotFoundException;
import com.example.assingmentTrackingSystem.repository.AssingmentRepository;
import com.example.assingmentTrackingSystem.service.AssingmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssingmentServiceImpl implements AssingmentService {

    @Autowired
    private AssingmentRepository assingmentRepository;

    @Override
    public AssignmentResponse createAssignment(AssignmentRequest assignmentRequest) {

        Assignment assignment = new Assignment();

        assignment.setTitle(assignmentRequest.getTitle());
        assignment.setDescription(assignmentRequest.getDescription());
        assignment.setSubject(assignmentRequest.getSubject());
        assignment.setDueDate(assignmentRequest.getDueDate());
        assignment.setMaxMarks(assignmentRequest.getMaxMarks());
        assignment.setStatus(assignmentRequest.getStatus());
        assignment.setTeacher(assignmentRequest.getTeacher());

        Assignment savedAssignment = assingmentRepository.save(assignment);

        return convertToResponse(savedAssignment);
    }

    @Override
    public List<AssignmentResponse> getAllAssignments() {

        return assingmentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public AssignmentResponse getAssignmentById(Long id) {

        Assignment assignment = assingmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException(
                                "Assignment not found with id: " + id
                        ));

        return convertToResponse(assignment);
    }

    @Override
    public AssignmentResponse updateAssignment(
            Long id,
            AssignmentRequest assignmentRequest) {

        Assignment assignment = assingmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException(
                                "Assignment not found with id: " + id
                        ));

        assignment.setTitle(assignmentRequest.getTitle());
        assignment.setDescription(assignmentRequest.getDescription());
        assignment.setSubject(assignmentRequest.getSubject());
        assignment.setDueDate(assignmentRequest.getDueDate());
        assignment.setMaxMarks(assignmentRequest.getMaxMarks());
        assignment.setStatus(assignmentRequest.getStatus());
        assignment.setTeacher(assignmentRequest.getTeacher());

        Assignment updatedAssignment = assingmentRepository.save(assignment);

        return convertToResponse(updatedAssignment);
    }

    @Override
    public void deleteAssignment(Long id) {

        Assignment assignment = assingmentRepository.findById(id)
                .orElseThrow(() ->
                        new AssignmentNotFoundException(
                                "Assignment not found with id: " + id
                        ));

        assingmentRepository.delete(assignment);
    }

    private AssignmentResponse convertToResponse(Assignment assignment) {

        AssignmentResponse response = new AssignmentResponse();

        response.setId(assignment.getId());
        response.setTitle(assignment.getTitle());
        response.setDescription(assignment.getDescription());
        response.setSubject(assignment.getSubject());
        response.setDueDate(assignment.getDueDate());
        response.setMaxMarks(assignment.getMaxMarks());
        response.setStatus(assignment.getStatus());
        response.setTeacher(assignment.getTeacher());

        return response;
    }
}