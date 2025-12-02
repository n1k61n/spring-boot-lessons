package az.edu.itbrains.fruitables.services;

import az.edu.itbrains.fruitables.dtos.about.AboutDto;
import az.edu.itbrains.fruitables.dtos.about.AboutUpdateDto;

public interface AboutService {
    AboutDto getAboutInfo();

    AboutUpdateDto getUpdatedAbout(Long id);

    AboutUpdateDto updateAbout(Long id, AboutUpdateDto aboutUpdateDto);
}


