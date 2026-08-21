package com.example.assingmentTrackingSystem.serviceImpl;

import com.example.assingmentTrackingSystem.dto.StudentRequest;
import com.example.assingmentTrackingSystem.dto.StudentResponse;
import com.example.assingmentTrackingSystem.entity.Student;
import com.example.assingmentTrackingSystem.exception.StudentNotFoundException;
import com.example.assingmentTrackingSystem.repository.StudentRepository;
import com.example.assingmentTrackingSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {

        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setRollNumber(studentRequest.getRollNumber());
        student.setCourse(studentRequest.getCourse());
        student.setBatch(studentRequest.getBatch());

        Student savedStudent = studentRepository.save(student);

        return convertToResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        ));

        return convertToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(
            Long id,
            StudentRequest studentRequest) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        ));

        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setRollNumber(studentRequest.getRollNumber());
        student.setCourse(studentRequest.getCourse());
        student.setBatch(studentRequest.getBatch());

        Student updatedStudent = studentRepository.save(student);

        return convertToResponse(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        ));

        studentRepository.delete(student);
    }

    private StudentResponse convertToResponse(Student student) {

        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setRollNumber(student.getRollNumber());
        response.setCourse(student.getCourse());
        response.setBatch(student.getBatch());

        return response;
    }
}