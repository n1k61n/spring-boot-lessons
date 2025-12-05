package com.example.agency.services;

import com.example.agency.dtos.request.PortfolioItemRequestDTO;
import com.example.agency.dtos.responce.PortfolioItemResponceDTO;

public interface PortfolioItemService {
    PortfolioItemResponceDTO getPortfolioItemById(Long id);
    PortfolioItemResponceDTO createPortfolioItem(PortfolioItemResponceDTO dto);
    PortfolioItemRequestDTO upatePortfolioItem(Long id, PortfolioItemResponceDTO dto);
    boolean deletePortfolioItem(Long id);
    
}
