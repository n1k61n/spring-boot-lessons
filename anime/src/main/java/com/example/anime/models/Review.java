package com.example.anime.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "anime_review") // Və ya sadəcə "reviews"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "created_at", updatable = false) // Yaradılma vaxtı yenilənməməlidir
    private LocalDateTime createdAt = LocalDateTime.now();

    // DÜZƏLİŞ 1: User əlaqəsi
    // --------------------------------------------------------------------------------
    // 'userId' əvəzinə 'User' Entity istifadə olunur.
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    // --------------------------------------------------------------------------------

    // DÜZƏLİŞ 2: Anime əlaqəsi
    // --------------------------------------------------------------------------------
    // 'animeId' əvəzinə 'Anime' Entity istifadə olunur.
    // Bu sahə Anime.java-dakı @OneToMany(mappedBy = "anime") ilə uyğunlaşır.
    @ManyToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;
    // --------------------------------------------------------------------------------
}