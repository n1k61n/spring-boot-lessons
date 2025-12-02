package com.example.anime.repositories;

import com.example.anime.models.Anime;
import com.example.anime.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
