package com.example.bootStrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    @GetMapping("/post.html")
    String about(){
        return "post.html";
    }
}
