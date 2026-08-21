package com.example.assingmentTrackingSystem.serviceImpl;

import com.example.assingmentTrackingSystem.dto.TeacherRequest;
import com.example.assingmentTrackingSystem.dto.TeacherResponse;
import com.example.assingmentTrackingSystem.entity.Teacher;
import com.example.assingmentTrackingSystem.exception.TeacherNotFoundException;
import com.example.assingmentTrackingSystem.repository.TeacherRepository;
import com.example.assingmentTrackingSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public TeacherResponse createTeacher(TeacherRequest teacherRequest) {

        Teacher teacher = new Teacher();

        teacher.setName(teacherRequest.getName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setDepartment(teacherRequest.getDepartment());

        Teacher savedTeacher = teacherRepository.save(teacher);

        return convertToResponse(savedTeacher);
    }


    @Override
    public List<TeacherResponse> getAllTeachers() {

        return teacherRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }


    @Override
    public TeacherResponse getTeacherById(Long id) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() ->
                        new TeacherNotFoundException(
                                "Teacher not found with id: " + id
                        ));

        return convertToResponse(teacher);
    }


    @Override
    public TeacherResponse updateTeacher(
            Long id,
            TeacherRequest teacherRequest) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() ->
                        new TeacherNotFoundException(
                                "Teacher not found with id: " + id
                        ));

        teacher.setName(teacherRequest.getName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setDepartment(teacherRequest.getDepartment());

        Teacher updatedTeacher = teacherRepository.save(teacher);

        return convertToResponse(updatedTeacher);
    }


    @Override
    public void deleteTeacher(Long id) {

        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() ->
                        new TeacherNotFoundException(
                                "Teacher not found with id: " + id
                        ));

        teacherRepository.delete(teacher);
    }


    private TeacherResponse convertToResponse(Teacher teacher) {

        TeacherResponse response = new TeacherResponse();

        response.setId(teacher.getId());
        response.setName(teacher.getName());
        response.setEmail(teacher.getEmail());
        response.setDepartment(teacher.getDepartment());

        return response;
    }
}