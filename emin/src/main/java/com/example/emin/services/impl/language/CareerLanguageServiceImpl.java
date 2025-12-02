package com.example.emin.services.impl.language;

import com.example.emin.repositories.languages.CareerLanguageRepository;
import com.example.emin.services.languages.CareerLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerLanguageServiceImpl implements CareerLanguageService {
    private final CareerLanguageRepository careerLanguageRepository;
}
