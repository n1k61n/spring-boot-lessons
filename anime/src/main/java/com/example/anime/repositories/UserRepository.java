package com.example.anime.repositories;

import com.example.anime.models.Anime;
import com.example.anime.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
