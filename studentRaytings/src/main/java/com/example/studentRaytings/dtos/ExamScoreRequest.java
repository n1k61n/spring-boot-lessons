package com.example.studentRaytings.dtos;



import lombok.Data; // Əgər Lombok istifadə edirsinizsə

@Data // Getter və Setter-ləri avtomatik əlavə edir
public class ExamScoreRequest {
    private double examScore;

    public double getExamScore() { return this.examScore; }
    public void setExamScore(double examScore) { this.examScore = examScore; }

    // Jackson-un ehtiyacı olan boş konstruktor (Lombok bunu avtomatik edir)
    // public ExamScoreRequest() {}

    // ... (Əgər Lombok yoxdursa, Getter/Setter əlavə edin)
}