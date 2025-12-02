package com.example.anime.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimeHomeDto {

    private Long id;
    private String title;
    private String imageUrl;
}
