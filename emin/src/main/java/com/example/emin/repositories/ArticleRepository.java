package com.example.emin.repositories;

import com.example.emin.models.Article;
import com.example.emin.models.languages.ArticleLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository  extends JpaRepository<Article, Long> {
}
