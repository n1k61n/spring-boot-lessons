package com.example.emin.services.impl.language;

import com.example.emin.repositories.languages.ArticleLanguageRepository;
import com.example.emin.services.languages.ArticleLanguageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleLanguageServiceImpl implements ArticleLanguageService {
    private final ArticleLanguageRepository articleLanguageRepository;
}
