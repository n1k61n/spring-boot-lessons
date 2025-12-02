package com.example.emin.repositories.languages;


import com.example.emin.models.languages.ArticleLanguage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleLanguageRepository extends JpaRepository<ArticleLanguage, Long> {

    // Assuming the property is actually named 'languageCode' in the entity
    @Query("SELECT al FROM ArticleLanguage al WHERE al.languageCode = :lang")
    List<ArticleLanguage> findByLang(@Param("lang") String lang);


    Optional<ArticleLanguage> findByArticleIdAndLang(Long articleId, String langCode);
}
