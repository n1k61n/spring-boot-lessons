package com.example.bootStrap.dtos.responce;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutResponceDTo {
    private Long id;
    private String mainTitle;

    private String subTitle;

    private String photoUrl;
    private String content;
    private String description;
}
