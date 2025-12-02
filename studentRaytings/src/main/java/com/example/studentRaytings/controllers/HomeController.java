package com.example.studentRaytings.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Maps the browser request URL 'http://localhost:8080/login.html'
    @GetMapping("/login.html")
    public String showLoginPage() {
        // Spring Boot/Thymeleaf will resolve this string 'login'
        // to the file located at: src/main/resources/templates/login.html
        return "login";
    }

    // --- Mappings for other templates ---

    // Maps the root URL 'http://localhost:8080/'
    @GetMapping("/index.html")
    public String showIndexPage() {
        return "index"; // Maps to index.html
    }

    // Maps the request URL 'http://localhost:8080/signup.html'
    @GetMapping("/signup.html")
    public String showSignupPage() {
        return "signup"; // Maps to signup.html
    }

    // Maps the request URL 'http://localhost:8080/quiz.html'
    @GetMapping("/quiz.html")
    public String showQuizPage() {
        return "quiz"; // Maps to quiz.html
    }
}
