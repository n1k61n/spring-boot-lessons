package com.example.anime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anime.models.Genre;

public interface GenreRepository  extends JpaRepository<Genre, Long> {
    
    
}
