package com.example.anime.repositories;

import com.example.anime.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimeRepository extends JpaRepository<Anime, Long> {
}


