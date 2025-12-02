package com.example.studentRaytings.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "students_score")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "right_answers", nullable = false)
    private Integer rightAnswers = 0;

    @Column(name = "wrong_answer", nullable = false)
    private Integer wrongAnswer = 0;

    @Column(name = "attempt_count", nullable = false)
    private Integer attemptCount = 0;


    @Column(name = "activity_score", nullable = false)
    private Double activityScore = 0.0;

    @Column(name = "gpa_score", nullable = false)
    private Double gpaScore = 0.0;

    @Column(name = "project_score", nullable = false)
    private Double projectScore = 0.0;

    @Column(name = "overall_score", nullable = false)
    private Double overallScore = 0.0;

    @Column(name = "exam_score", nullable = false)
    private Double examScore = 0.0;

    @Column(name = "rank")
    private Integer rank = 0;

    @Column(name = "test_date")
    private LocalDateTime testDate = null;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;
}