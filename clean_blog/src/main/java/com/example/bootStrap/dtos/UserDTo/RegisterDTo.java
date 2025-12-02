package com.example.bootStrap.dtos.UserDTo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDTo {
    private String name;
    private String surName;
    private String email;
    private String password;
    private String confirmPassword;
}
