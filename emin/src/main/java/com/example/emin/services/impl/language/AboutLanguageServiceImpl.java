package com.example.emin.services.impl.language;

import com.example.emin.repositories.languages.AboutLanguageRepository;

import com.example.emin.services.languages.AboutLanguageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutLanguageServiceImpl implements AboutLanguageService {
    private final AboutLanguageRepository articleLanguageRepository;
}
