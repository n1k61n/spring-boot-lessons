package com.example.anime.config;

import com.example.anime.models.Genre;
import org.springframework.boot.CommandLineRunner;


import com.example.anime.repositories.GenreRepository;

import java.util.List;

public class DataSeeder implements CommandLineRunner {

    private final GenreRepository genreRepository;

    public DataSeeder(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Genre> genreList = genreRepository.findAll();

        if(genreList.isEmpty()){
            List<Genre> genres = List.of(
                    new Genre("Aksiya"),
            new Genre("Macəra"),
            new Genre("Komediya"),
            new Genre("Dram"),
            new Genre("Romantika"),
            new Genre("Fantaziya"),
            new Genre("Elmi-fantastika"),
            new Genre("Qorxu"),
            new Genre("Triller"),
            new Genre("Gizəmli"),
            new Genre("Tarixi"),
            new Genre("Gündəlik Həyat"),
            new Genre("Psixoloji"),
            new Genre("Fövqəltəbii"),
            new Genre("Məktəb"),
            new Genre("İdman"),
            new Genre("Musiqi"),
            new Genre("Hərbi"),
            new Genre("Cinayət"),
            new Genre("Ailə"),
            new Genre("Vestern"),
            new Genre("Sənədli"),
            new Genre("Müharibə"),
            new Genre("Sehr"),
            new Genre("Samuray"),
            new Genre("Uşaq"),
            new Genre("Parodiya"),
            new Genre("Siyasi"),
            new Genre("Bioqrafik"),
            new Genre("Mexa")
            );
            genreRepository.saveAll(genres);
        }
    }
    
}
