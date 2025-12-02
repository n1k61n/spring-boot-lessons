package com.example.studentRaytings.repositories;

import com.example.studentRaytings.models.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SteudentScoreRepository extends JpaRepository<StudentScore, Long>{
    Optional<StudentScore> findById(Long id);
}
