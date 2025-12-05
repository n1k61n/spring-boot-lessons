package com.example.agency.services.impl;


import com.example.agency.dtos.responce.PortfolioItemResponceDTO;
import com.example.agency.models.PortfolioItem;
import com.example.agency.services.PortfolioItemService;

import java.util.HashMap;
import java.util.Map;



public class PortfolioItemServiceImpl implements PortfolioItemService {

    // Nümunəvi məlumat bazası yerini tutmaq üçün HashMap istifadə edirik
    private final Map<Long, PortfolioItemResponceDTO> repository = new HashMap<>();
    private Long nextId = 1L;

    // --- 1. READ Metodu: Elementi ID ilə Gətirmək ---
    @Override
    public PortfolioItemResponceDTO getPortfolioItemById(Long id) {
        System.out.println("-> Portfolio elementi ID=" + id + " ilə axtarılır...");

        PortfolioItemResponceDTO item = repository.get(id);

        if (item != null) {
            System.out.println("-> Element tapıldı: " + item.getName());
            return item;
        } else {
            System.out.println("-> XƏTA: Element ID=" + id + " tapılmadı.");
            // Real tətbiqdə NotFoundException atılmalıdır
            return null;
        }
    }


    @Override
    public PortfolioItemResponceDTO createPortfolioItem(PortfolioItemResponceDTO dto) {
        PortfolioItem portfolioItem = new PortfolioItem();
        portfolioItem.setCategory(dto.getCategory());
        portfolioItem.setDescription(dto.getDescription());
        portfolioItem.setImageUrl(dto.getImageUrl());
        portfolioItem.setTitle(dto.getTitle());
        repository.save
        return dto;
    }


    @Override
    public boolean deletePortfolioItem(Long id) {
        return repository.remove(id) != null;
    }
}