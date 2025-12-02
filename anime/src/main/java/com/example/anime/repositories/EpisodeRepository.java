package com.example.anime.repositories;

import com.example.anime.models.Anime;
import com.example.anime.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
