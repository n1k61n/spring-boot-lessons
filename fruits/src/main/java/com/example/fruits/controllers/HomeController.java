package com.example.fruits.controllers;

import org.springframework.web.bind.annotation.GetMapping;


public class HomeController {

    @GetMapping("/")
     public String index(){
         return "Hello world";
     }
}
