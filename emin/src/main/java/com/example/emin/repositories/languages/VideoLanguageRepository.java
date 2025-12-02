package com.example.emin.repositories.languages;

import com.example.emin.models.About;
import com.example.emin.models.languages.VideoLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLanguageRepository extends JpaRepository<VideoLanguage, Long> {
}
