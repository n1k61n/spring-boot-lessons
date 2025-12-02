package com.example.emin.models;

import jakarta.persistence.*;

@Entity
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
