package com.example.emin.models;

import com.example.emin.models.languages.ArticleLanguage;
import com.example.emin.models.languages.BloggingEraLanguage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BloggingEra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;

    @OneToMany(mappedBy = "bloggingEra")
    private List<BloggingEraLanguage> bloggingEraLanguages = new ArrayList<>();



}
