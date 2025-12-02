package com.example.bootStrap.repostories;

import com.example.bootStrap.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
