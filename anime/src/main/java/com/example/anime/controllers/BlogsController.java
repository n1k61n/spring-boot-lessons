package com.example.anime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogsController {

    @GetMapping("/blog")
    public String blogs() {
        return "blog/blog-index.html";
    }

    @GetMapping("/blog/detail")
    public String blogDetail() {
        return "blog/blog-details.html";
    }
}
