package az.edu.itbrains.fruitables.controllers;


import az.edu.itbrains.fruitables.dtos.about.AboutDto;
import az.edu.itbrains.fruitables.dtos.about.AboutUpdateDto;
import az.edu.itbrains.fruitables.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping
    public ResponseEntity<AboutDto> getAbout(){

        AboutDto about = aboutService.getAboutInfo();
        return new ResponseEntity<>(about, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<AboutUpdateDto> getAboutUpdate(@PathVariable Long id){

        AboutUpdateDto aboutUpdateDto = aboutService.getUpdatedAbout(id);
        return new ResponseEntity<>(aboutUpdateDto, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<AboutUpdateDto> getAboutUpdate(@PathVariable Long id, @RequestBody AboutUpdateDto aboutUpdateDto){
        AboutUpdateDto about = aboutService.updateAbout(id, aboutUpdateDto);
        return new ResponseEntity<>(about, HttpStatus.OK);
    }



}
