package com.example.bootStrap.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BannerRequestDTo {
    private String mainTitle;

    private String subTitle;

    private String photoUrl;
}
