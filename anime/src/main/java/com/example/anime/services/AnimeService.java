package com.example.anime.services;

import com.example.anime.dtos.AnimeHomeDto;

import java.util.List;

public interface AnimeService {
    List<AnimeHomeDto> getHomeAnime();
}
