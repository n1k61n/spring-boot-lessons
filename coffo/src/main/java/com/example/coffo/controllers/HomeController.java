package com.example.coffo.controllers;


import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.DTOs.responce.TestimonialResponceDTO;
import com.example.coffo.services.AboutService;
import com.example.coffo.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final AboutService aboutService;
    private final ModelMapper modelMapper;
    private final TestimonialService testimonialService;

    @GetMapping("/index.html")
    public String home(Model model) {
        AboutResponceDTO aboutResponceDTO = aboutService.getAboutInfo(1l);
        model.addAttribute("aboutInfo", aboutResponceDTO);
        List<TestimonialResponceDTO> testimonialResponceDTOS =  testimonialService.getAll();
        model.addAttribute("testimonials", testimonialResponceDTOS);
        return "index.html";
    }

    @GetMapping("/about.html")
    public String about() {
        return "about";
    }

    @GetMapping("/coffees.html")
    public String coffee() {
        return "coffees";
    }

    @GetMapping("/blog.html")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contact.html")
    public String contact() {
        return "contact";
    }
}


