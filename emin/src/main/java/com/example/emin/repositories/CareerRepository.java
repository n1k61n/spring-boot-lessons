package com.example.emin.repositories;

import com.example.emin.models.About;
import com.example.emin.models.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
