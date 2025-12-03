package com.example.coffo.controllers;

import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.DTOs.responce.TestimonialResponceDTO;
import com.example.coffo.models.Testimonial;
import com.example.coffo.services.AboutService;
import com.example.coffo.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AboutService aboutService;
    private final ModelMapper modelMapper;
    private final TestimonialService testimonialService;

    @GetMapping("/index.html")
    public String home(Model model){
        AboutResponceDTO aboutResponceDTO = aboutService.getAboutInfo(1L);
        model.addAttribute("aboutInfo", aboutResponceDTO);

        List<TestimonialResponceDTO> testimonialResponceDTOS = testimonialService.getAll();
        return "index";
    }

    @GetMapping("/about.html")
    public String about(Model model){
        return "about";
    }

    @GetMapping("/blog.html")
    public String blog(Model model){
        return "blog";
    }

    @GetMapping("/coffees.html")
    public String coffees(Model model){
        return "coffees";
    }

    @GetMapping("/contact.html")
    public String contact(Model model){
        return "contact";
    }
}
