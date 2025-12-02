package com.example.emin.models;

import com.example.emin.models.languages.AboutLanguage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photourl;


    @OneToMany(mappedBy = "about")
    private List<AboutLanguage> aboutLanguages = new ArrayList<>();




}
