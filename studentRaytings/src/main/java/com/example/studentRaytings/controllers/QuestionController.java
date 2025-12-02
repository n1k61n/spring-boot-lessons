package com.example.studentRaytings.controllers;


import com.example.studentRaytings.models.Question;
import com.example.studentRaytings.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 50 random sual endpoint
    @GetMapping("/questions")
    public List<Question> getQuizQuestions() {
        return questionService.get50RandomQuestions();
    }


    // istəyə görə count dəyişmək üçün generic endpoint
    @GetMapping("/questions/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }
}
