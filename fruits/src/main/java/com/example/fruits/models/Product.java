package com.example.fruits.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @Column(unique = true, length = 10)
    private String barcode;

    @Column(unique = true)
    private String sku;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;
    private BigDecimal discount;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String shortDescription;


    private String stock;
    @Column(name="image_url")
    private String imageUrl;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Cart cart;
}