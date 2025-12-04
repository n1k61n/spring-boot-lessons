package com.example.coffo.services.impl;

import com.example.coffo.DTOs.responce.AboutResponceDTO;


import com.example.coffo.models.About;
import com.example.coffo.repositories.AboutRepository;
import com.example.coffo.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604


@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;


    @Override
<<<<<<< HEAD
    public AboutResponceDTO getAboutInfo(long id) {
        // 1. Repository-dən Entity-ni tapaq (findById JpaRepository-dən miras alınır)
        Optional<About> aboutEntityOptional = aboutRepository.findById(id);
=======
    public AboutResponceDTO getAboutInfo() {
        return aboutRepository.getAboutInfoBy();

    }


}
>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604

        // 2. Tapılmasa istisna atılır (və ya başqa bir məntiq tətbiq edilir)
        About aboutEntity = aboutEntityOptional.orElseThrow(() ->
                new RuntimeException("ID " + id + " olan 'About' qeydi tapılmadı."));

        // 3. Entity-ni DTO-ya çevirib qaytarırıq (ModelMapper ilə)
        return modelMapper.map(aboutEntity, AboutResponceDTO.class);
    }
}