package com.example.assingmentTrackingSystem.dto;

import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String name;
    private String email;
    private String rollNumber;
    private String course;
    private String batch;
}