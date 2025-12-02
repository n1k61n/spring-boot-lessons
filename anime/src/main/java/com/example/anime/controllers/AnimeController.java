package com.example.anime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimeController {

    @GetMapping("/anime-details.html")
    public String anime() {
        return "anime-details.html";
    }


    @GetMapping("/anime-watching.html")
    public String watch() {
        return "anime-watching.html";
    }
}
