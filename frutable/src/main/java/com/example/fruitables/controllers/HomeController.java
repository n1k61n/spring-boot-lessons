package com.example.fruitables.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@Controller
public class HomeController {


    
    public String home(){
        return "index.html";
    }
}
