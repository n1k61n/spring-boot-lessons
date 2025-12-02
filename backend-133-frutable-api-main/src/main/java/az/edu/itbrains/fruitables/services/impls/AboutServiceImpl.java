package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.dtos.about.AboutDto;
import az.edu.itbrains.fruitables.dtos.about.AboutUpdateDto;
import az.edu.itbrains.fruitables.models.About;
import az.edu.itbrains.fruitables.repositories.*;
import az.edu.itbrains.fruitables.services.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;

    @Override
    public AboutDto getAboutInfo() {
        AboutDto about = modelMapper.map(aboutRepository.findById(1L).get(), AboutDto.class);
        if (about != null) {
            return about;
        }
        return null;
    }

    @Override
    public AboutUpdateDto getUpdatedAbout(Long id) {
        AboutUpdateDto about = modelMapper.map(aboutRepository.findById(id).get(), AboutUpdateDto.class);
        if (about != null) {
            return about;
        }
        return null;
    }

    @Override
    public AboutUpdateDto updateAbout(Long id, AboutUpdateDto aboutUpdateDto) {
        About about = aboutRepository.findById(id).get();
        if (about != null) {
            about.setDescription(aboutUpdateDto.getDescription());
            about.setTitle(aboutUpdateDto.getTitle());
            about.setImage(aboutUpdateDto.getImage());
            aboutRepository.save(about);
            return aboutUpdateDto;
        }
        return null;
    }
}

