package com.example.studentRaytings.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email; 
    
    private String password;

    @Column(nullable = false)
    private String groupName;

    private Integer totalExams;     // Cəmi imtahan sayı
    private Integer correctAnswers; // Düz cavablar
    private Integer wrongAnswers;   // Səhv cavablar
    private Integer totalScore;     // Cəmi xal


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ExamResult> exams = new ArrayList<>();


}
