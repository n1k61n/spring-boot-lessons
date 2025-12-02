package com.example.emin.models;

import com.example.emin.models.languages.VideoLanguage;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;

    @OneToMany(mappedBy = "video")
    private List<VideoLanguage> videoLanguages = new ArrayList<>();

    @ManyToOne
    private VideoType videoType;
}