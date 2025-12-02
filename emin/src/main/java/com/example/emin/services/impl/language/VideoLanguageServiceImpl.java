package com.example.emin.services.impl.language;


import com.example.emin.repositories.languages.VideoLanguageRepository;
import com.example.emin.services.languages.VideoLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoLanguageServiceImpl implements VideoLanguageService {
    private final VideoLanguageRepository videoLanguageRepository;
}
