package com.example.studentRaytings.services;

import com.example.studentRaytings.models.Question;
import com.example.studentRaytings.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // count qədər təsadüfi sual çəkir
    public List<Question> getRandomQuestions(int count) {
        // Prefer db-level random selection to avoid duplicates and large-memory shuffles.
        long total = questionRepository.count();
        if (total == 0) {
            return Collections.emptyList();
        }

        final int limit = (int) Math.min(count, total);
        return questionRepository.findRandomQuestions(limit);
    }

    // 50 random sual üçün shortcut
    public List<Question> get50RandomQuestions() {
        long total = questionRepository.count();
        if (total == 0) return Collections.emptyList();
        final int limit = (int) Math.min(50, total);
        return questionRepository.findRandomQuestions(limit);
    }
}
