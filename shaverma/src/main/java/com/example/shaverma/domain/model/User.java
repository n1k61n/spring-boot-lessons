package com.example.shaverma.domain.model;

import lombok.Data;

import java.awt.*;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String passord;
    private String telegram;
    private String address;
}


