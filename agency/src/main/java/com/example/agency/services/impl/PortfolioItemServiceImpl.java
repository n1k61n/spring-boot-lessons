package com.example.agency.services.impl;

import com.example.agency.dtos.request.PortfolioItemRequestDTO;
import com.example.agency.dtos.responce.PortfolioItemResponceDTO;
import com.example.agency.models.PortfolioItem;
import com.example.agency.repositories.PortfolioItemRepository;
import com.example.agency.services.PortfolioItemService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PortfolioItemServiceImpl implements PortfolioItemService {
    private final PortfolioItemRepository portfolioItemRepository;


    @Override
    public PortfolioItemResponceDTO getPortfolioItemById(Long id) {
        return null;
    }

    @Override
    public PortfolioItemResponceDTO createPortfolioItem(PortfolioItemResponceDTO dto) {
        return null;
    }

    @Override
    public PortfolioItemRequestDTO upatePortfolioItem(Long id, PortfolioItemResponceDTO dto) {
        return null;
    }



    @Override
    public boolean deletePortfolioItem(Long id) {
        // Attempt to find the item
        Optional<PortfolioItem> itemOptional = portfolioItemRepository.findById(id);

        if (itemOptional.isPresent()) {
            // Log the successful deletion (assuming you have a Logger defined)
            // log.info("Deleting Portfolio item with id: {}", id);
            portfolioItemRepository.delete(itemOptional.get());
            return true;
        } else {
            // Log the failure before throwing the exception
            // log.warn("Attempted to delete non-existent Portfolio item with id: {}", id);
            throw new IllegalArgumentException("Portfolio item not found with id: " + id);
        }
    }

}
