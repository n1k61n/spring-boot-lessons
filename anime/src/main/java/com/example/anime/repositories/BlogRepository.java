package com.example.anime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anime.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>    {
    
}
