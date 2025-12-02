package com.example.anime.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    // DÜZƏLİŞ: ManyToOne əlaqəsi Entity (User) üzərində qurulmalıdır.
    @ManyToOne // Bir çox bloq bir müəllifə (User) aiddir.
    @JoinColumn(name="user_id", nullable=false) // user_id sütunu xarici açardır (Foreign Key).
    private User author; // Müəllifi təmsil edən 'User' Entity sinfi.
}