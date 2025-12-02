package com.example.emin.models.languages;

import com.example.emin.models.BloggingEra;
import jakarta.persistence.*;

@Entity
public class BloggingEraLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blogging_era_id")
    private BloggingEra bloggingEra;
}
