package com.example.bootStrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact.html")
    String about(){
        return "contact.html";
    }
}
