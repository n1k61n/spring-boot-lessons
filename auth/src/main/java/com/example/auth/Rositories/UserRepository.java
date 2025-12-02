package com.example.auth.Rositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.Models.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
