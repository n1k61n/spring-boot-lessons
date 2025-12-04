package com.example.coffo.controllers;


import com.example.coffo.services.AboutService;
import com.example.coffo.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final AboutService aboutService;
    private final ModelMapper modelMapper;
    private final TestimonialService testimonialService;

    @GetMapping
    public String index() {
        return "index";
    }

}
