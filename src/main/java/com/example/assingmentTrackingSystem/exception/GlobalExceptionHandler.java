package com.example.assingmentTrackingSystem.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AssignmentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleAssingmentNotFound(
            AssignmentNotFoundException ex) {
        return buildResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFound(
            StudentNotFoundException ex) {

        return buildResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(SubmissionNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSubmissionNotFound(
            SubmissionNotFoundException ex) {

        return buildResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleTeacherNotFound(
            TeacherNotFoundException ex) {

        return buildResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(
            Exception ex) {

        return buildResponse(
                "Something went wrong. Please try again.",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    private ResponseEntity<Map<String, Object>> buildResponse(
            String message,
            HttpStatus status) {

        Map<String, Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("error", status.getReasonPhrase());
        response.put("message", message);
        return new ResponseEntity<>(response, status);
    }
}