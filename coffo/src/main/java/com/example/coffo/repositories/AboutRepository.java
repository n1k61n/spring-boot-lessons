package com.example.coffo.repositories;

import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.models.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository  extends JpaRepository<About, Long> {
<<<<<<< HEAD
=======

    AboutResponceDTO getAboutInfoBy();

>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604
}


