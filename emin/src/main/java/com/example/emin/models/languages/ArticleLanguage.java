package com.example.emin.models.languages;

import com.example.emin.models.Article;
import jakarta.persistence.*;
import lombok.Data;


@Entity
public class ArticleLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String languageCode;
    private String lang;


    private String title;
    private String description;
    private String photoUrl;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public ArticleLanguage() {}



}
