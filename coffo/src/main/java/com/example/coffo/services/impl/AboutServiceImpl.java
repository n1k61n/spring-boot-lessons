package com.example.coffo.services.impl;


import com.example.coffo.DTOs.request.AboutRequestDTO;
import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.models.About;
import com.example.coffo.repositories.AboutRepository;
import com.example.coffo.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;


    @Override
    public AboutResponceDTO getAboutInfo(Long id) {
        // 1. Repository-dən Entity-ni tapaq (findById JpaRepository-dən miras alınır)
        Optional<About> aboutEntityOptional = aboutRepository.findById(id);




        // 2. Tapılmasa istisna atılır (və ya başqa bir məntiq tətbiq edilir)
        About aboutEntity = aboutEntityOptional.orElseThrow(() ->
                new RuntimeException("ID " + id + " olan 'About' qeydi tapılmadı."));

        // 3. Entity-ni DTO-ya çevirib qaytarırıq (ModelMapper ilə)
        return modelMapper.map(aboutEntity, AboutResponceDTO.class);
    }
}