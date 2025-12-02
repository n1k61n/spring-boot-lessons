package com.example.emin.services.impl.language;


import com.example.emin.repositories.languages.SocialNetworkLanguageRepository;
import com.example.emin.services.languages.SocialNetworkLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialNetworkLanguageServiceImpl implements SocialNetworkLanguageService {
    private final SocialNetworkLanguageRepository socialNetworkLanguageRepository;
}
