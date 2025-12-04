package com.example.agency.models;

import jakarta.persistence.*;

@Entity
@Table(name = "about")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heading;
    private String description;
    @Column(name="image_url")
    private String imageUrl;
}