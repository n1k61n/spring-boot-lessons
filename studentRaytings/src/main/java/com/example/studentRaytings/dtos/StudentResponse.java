package com.example.studentRaytings.dtos;

import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String fullName;
    private String groupName;

    private Integer totalExams;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer totalScore;
}
