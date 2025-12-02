package com.example.anime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index.html";
    }


    @GetMapping("/anime-details")
    public String animeDetails() {
        return "anime-details.html";
    }

}
