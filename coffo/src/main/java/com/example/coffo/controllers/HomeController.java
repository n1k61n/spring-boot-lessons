package com.example.coffo.controllers;


import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {



    @GetMapping("/")
    public String index() {
        return "index";
    }
}


