package com.example.emin.models.languages;

import com.example.emin.models.Video;
import jakarta.persistence.*;

@Entity
public class VideoTypeLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String desciption;

    private String langCode;

    @ManyToOne
    private Video video;

}
