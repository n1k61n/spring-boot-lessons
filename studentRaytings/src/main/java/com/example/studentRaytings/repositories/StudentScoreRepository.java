package com.example.studentRaytings.repositories;

import com.example.studentRaytings.models.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
    List<StudentScore> findAllByOrderByOverallScoreDesc();
    // Find a StudentScore by the associated Student's id
    java.util.Optional<com.example.studentRaytings.models.StudentScore> findByStudentId(Long studentId);
}
