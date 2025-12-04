package com.example.agency.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "portfolio_items")
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // Layihənin adı, məsələn: "Website Redesign"
    private String description; // Qısa izah: "Modern responsive design for client"
    @Column(name = "image_url")
    private String imageUrl;    // Şəkilin linki (frontend-də göstərmək üçün)
    private String category;    // Məsələn: "Web Development", "Graphic Design"


}
