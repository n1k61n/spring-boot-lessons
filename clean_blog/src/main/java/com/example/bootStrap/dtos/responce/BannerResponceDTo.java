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
public class BannerResponceDTo {


    private String mainTitle;

    private String subTitle;

    private String photoUrl;
}
