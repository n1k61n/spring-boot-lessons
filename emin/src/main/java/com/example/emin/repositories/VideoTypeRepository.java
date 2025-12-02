package com.example.emin.repositories;

import com.example.emin.models.About;
import com.example.emin.models.VideoType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoTypeRepository extends JpaRepository<VideoType, Long> {
}
