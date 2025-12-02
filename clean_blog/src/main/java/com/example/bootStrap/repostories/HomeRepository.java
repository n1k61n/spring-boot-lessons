package com.example.bootStrap.repostories;

import com.example.bootStrap.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Banner, Long> {
}
