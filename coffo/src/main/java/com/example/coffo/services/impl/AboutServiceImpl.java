package com.example.coffo.services.impl;

import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.repositories.AboutRepository;
import com.example.coffo.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;

    @Override
    public AboutResponceDTO getAboutInfo(long l) {
        return aboutRepository.getAboutInfo();
    }
}

