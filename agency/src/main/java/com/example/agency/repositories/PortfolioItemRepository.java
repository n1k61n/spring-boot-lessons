package com.example.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agency.models.PortfolioItem;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    
}
