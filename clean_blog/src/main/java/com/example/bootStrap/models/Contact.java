package com.example.bootStrap.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_title")
    private String mainTitle;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "photo_url")
    private String description;

    private String name;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String message;


}
