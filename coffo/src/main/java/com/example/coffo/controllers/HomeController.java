package com.example.coffo.controllers;

<<<<<<< HEAD
import com.example.coffo.DTOs.responce.AboutResponceDTO;
import com.example.coffo.DTOs.responce.TestimonialResponceDTO;
=======
>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604

import com.example.coffo.services.AboutService;
import com.example.coffo.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604



@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final AboutService aboutService;
    private final TestimonialService testimonialService;

<<<<<<< HEAD
    @GetMapping("/index.html")
    public String home(Model model) {
        AboutResponceDTO aboutResponceDTO = aboutService.getAboutInfo(1L);
        model.addAttribute("aboutInfo", aboutResponceDTO);
        List<TestimonialResponceDTO> testimonialResponceDTOS = testimonialService.getAll();
        return "index";
    }
}
=======
    @GetMapping
    public String index() {
        return "index";
    }

}
>>>>>>> 519a1ffac9e9c4dcce4e4c2ff3ba676a9e7d8604
