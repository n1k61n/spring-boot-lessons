package com.example.studentRaytings.models;

import com.example.studentRaytings.models.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "exam_results")
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
