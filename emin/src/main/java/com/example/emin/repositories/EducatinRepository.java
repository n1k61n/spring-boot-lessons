package com.example.emin.repositories;

import com.example.emin.models.About;
import com.example.emin.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducatinRepository extends JpaRepository<Education, Long> {
}
