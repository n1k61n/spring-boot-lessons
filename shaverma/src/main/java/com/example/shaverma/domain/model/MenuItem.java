package com.example.shaverma.domain.model;

import com.example.shaverma.domain.enums.MenuSection;
import lombok.Data;

@Data
public class MenuItem{
    private Long id;
    private String name;
    private MenuSection menuSection;
    private Double price;

}


