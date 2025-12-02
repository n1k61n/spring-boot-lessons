package com.example.emin.repositories;

import com.example.emin.models.About;
import com.example.emin.models.BloggingEra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggingEraRepository extends JpaRepository<BloggingEra, Long> {
}
