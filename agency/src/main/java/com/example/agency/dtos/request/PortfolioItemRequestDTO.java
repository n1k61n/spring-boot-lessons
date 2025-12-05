package com.example.agency.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioItemRequestDTO {
    private String title;       // Layihənin adı, məsələn: "Website Redesign"
    private String description; // Qısa izah: "Modern responsive design for client"

    private String imageUrl;    // Şəkilin linki (frontend-də göstərmək üçün)
    private String category;
}

