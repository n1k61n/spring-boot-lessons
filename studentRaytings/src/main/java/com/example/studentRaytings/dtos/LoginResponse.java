package com.example.studentRaytings.dtos;


import lombok.Data;

@Data
public class LoginResponse {
    private Long userId;
    private Long studentId;
    private String name;
    private String message;

    public LoginResponse(Long userId, Long studentId, String name, String message) {
        this.userId = userId;
        this.studentId = studentId;
        this.name = name;
        this.message = message;
    }
}