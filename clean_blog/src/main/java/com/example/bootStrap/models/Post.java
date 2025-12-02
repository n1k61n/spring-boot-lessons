package com.example.bootStrap.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_title")
    private String mainTitle;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "header_photo_url")
    private String headerPhotoUrl;
    private String content;
    private String description;

    @ManyToOne
    private User author;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "is_published")
    private Boolean isPublished;
}
