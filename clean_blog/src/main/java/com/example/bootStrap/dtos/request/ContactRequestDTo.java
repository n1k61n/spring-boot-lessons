package com.example.bootStrap.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactRequestDTo {
    private String mainTitle;

    private String subTitle;

    private String description;

    private String name;
    private String email;

    private String phoneNumber;
    private String message;
}
