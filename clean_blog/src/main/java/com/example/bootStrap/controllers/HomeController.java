package com.example.bootStrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/index.html")
    String home() {
        return "index";
    }

}