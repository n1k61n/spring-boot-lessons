package com.example.emin.services.impl.language;


import com.example.emin.repositories.languages.BloggingEraLanguageRepository;
import com.example.emin.services.languages.BloggingEraLanguageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BloggingEraLanguageServiceImpl implements BloggingEraLanguageService {
    private final BloggingEraLanguageRepository bloggingEraLanguageRepository;
}
