package com.example.emin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/index.html")
    String home() {
        return "index.html";
    }

    @GetMapping("/portfolio.html")
    String portfolio(){
        return "portfolio.html";
    }
}