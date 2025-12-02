package com.example.anime.services.impl;

import com.example.anime.dtos.AnimeHomeDto;
import com.example.anime.models.Anime;
import com.example.anime.repositories.AnimeRepository;
import com.example.anime.services.AnimeService;

import java.util.List;

public class AnimeServiceImpl implements AnimeService {


    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public List<AnimeHomeDto> getHomeAnime() {
        List<Anime> animes = animeRepository.findAll();


        List<AnimeHomeDto> animeHomeDtos = animes.stream().map(anime -> {
            AnimeHomeDto dto = new AnimeHomeDto();
            dto.setId(anime.getId());
            dto.setTitle(anime.getTitle());
            dto.setImageUrl(anime.getImageUrl());
            return dto;
        }).toList();

        return animeHomeDtos;
    }
}
