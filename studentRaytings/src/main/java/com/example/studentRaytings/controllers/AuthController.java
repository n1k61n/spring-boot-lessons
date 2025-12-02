package com.example.studentRaytings.controllers;

import com.example.studentRaytings.dtos.LoginResponse;
import com.example.studentRaytings.models.Student;
import com.example.studentRaytings.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth") // Autentifikasiya endpointləri üçün əsas yol
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Student student) {
        try {
            Student registeredStudentProfile = authService.registerUser(student);
            return new ResponseEntity<>(registeredStudentProfile, HttpStatus.CREATED); // 201 Created
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Student studentProfileLogin) {
        try {
            Student studentProfile = authService.loginUser(studentProfileLogin.getEmail(), studentProfileLogin.getPassword());

            Long studentId = studentProfile.getId();


            LoginResponse response = new LoginResponse(
                    studentProfile.getId(),
                    studentId,
                    studentProfile.getName(),
                    "Giriş uğurludur!"
            );
            return ResponseEntity.ok(response); // JSON obyektini qaytarır

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401
        }
    }
}
