package com.example.coffo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/index.html")
    public String home(Model model){
        return "index";
    }

    @GetMapping("/about.html")
    public String about(Model model){
        return "about";
    }

    @GetMapping("/blog.html")
    public String blog(Model model){
        return "blog";
    }

    @GetMapping("/coffees.html")
    public String coffees(Model model){
        return "coffees";
    }

    @GetMapping("/contact.html")
    public String contact(Model model){
        return "contact";
    }
}
