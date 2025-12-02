package com.example.emin.models;


import com.example.emin.models.languages.ArticleLanguage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;

//    @OneToMany(mappedBy = "article")
//    private List<ArticleLanguage> articleLanguages = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleLanguage> languages = new ArrayList<>();


}
