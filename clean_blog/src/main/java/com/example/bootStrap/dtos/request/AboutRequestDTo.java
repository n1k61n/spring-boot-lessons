package com.example.bootStrap.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutRequestDTo {
    private String mainTitle;

    private String subTitle;

    private String photoUrl;
    private String content;
    private String description;
}
