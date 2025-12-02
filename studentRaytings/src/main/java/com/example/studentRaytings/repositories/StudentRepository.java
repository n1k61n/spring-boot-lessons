package com.example.studentRaytings.repositories;


import com.example.studentRaytings.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA avtomatik olaraq CRUD metodlarını (save, findById, findAll) təmin edir.
    // Additional custom methods for Student repository (if needed) can go here.
    List<Student> findAllByOrderByTotalScoreDesc();
}