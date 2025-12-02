package com.example.bootStrap.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "banners")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "main_title")
    private String mainTitle;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "photo_url")
    private String photoUrl;

}
