package com.example.coffo.services.impl;


import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.models.About;
import com.example.coffo.repositories.AboutRepository;
import com.example.coffo.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {


    @Override
    public AboutResponceDTO getAboutInfo(long l) {
        return null;
    }
}