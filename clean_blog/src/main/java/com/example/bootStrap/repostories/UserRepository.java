package com.example.bootStrap.repostories;

import com.example.bootStrap.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
