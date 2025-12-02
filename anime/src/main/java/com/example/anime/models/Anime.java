package com.example.anime.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.anime.enums.AnimeStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT") // Məlumatın uzunluğunu artırmaq üçün tövsiyə olunur
    private String description;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "image_url")
    private String imageUrl;

    // DÜZƏLİŞ 1: Status Field
    // ----------------------------------------------------------------------
    // @ManyToOne SİLİNDİ, çünki String @Entity sinfi deyil.
    @Enumerated(EnumType.STRING) // Ən yaxşı təcrübə: Enum istifadə edin və bazada STRING kimi saxlayın
    private AnimeStatus status; // Bu, ayrı bir Enum sinfi olmalıdır (aşağıya baxın)
    // ----------------------------------------------------------------------

    @Column(name = "views")
    private Integer views;

    // Yadda saxlayın ki, 'rayting' deyil, 'rating' (reytinq) ingilis dilindədir.
    // Verilənlər bazası sütun adı üçün @Column istifadə etmək tövsiyə olunur.
    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "anime")
    // DÜZƏLİŞ 2: Review Entity'si ilə əlaqə (Güman edilir ki, Review-da Anime növündə bir sahə var)
    private List<Review> reviews = new ArrayList<>(); // Yeni List başlatmaq yaxşı təcrübədir

    @ManyToMany
    @JoinTable(
            name = "anime_genre",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();


}