package com.example.emin.models.languages;


import com.example.emin.models.About;
import jakarta.persistence.*;

@Entity
public class AboutLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    private String langCode;
    @ManyToOne
    private About about;


}
