package com.example.emin.services.impl.language;


import com.example.emin.repositories.languages.EducationLanguageRepository;
import com.example.emin.services.languages.EducationLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationLanguageServiceImpl implements EducationLanguageService {
    private final EducationLanguageRepository educationLanguageRepository;
}
