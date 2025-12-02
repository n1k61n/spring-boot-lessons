package com.example.studentRaytings.dtos;

import lombok.Data;

@Data
public class StudentRequest {

    private String fullName;
    private String groupName;

    private Integer totalExams;
    private Integer correctAnswers;
    private Integer wrongAnswers;
}
