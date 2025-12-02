package com.example.fruits.repositories;

import com.example.fruits.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
 
}