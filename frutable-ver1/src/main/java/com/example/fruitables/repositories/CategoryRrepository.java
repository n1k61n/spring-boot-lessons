package com.example.fruitables.repositories;


import com.example.fruitables.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRrepository extends JpaRepository<Category, Long> {
}
