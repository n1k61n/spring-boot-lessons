package com.example.shaverma.domain.model;

import com.example.shaverma.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order{
    private Long id;
    private LocalDateTime dateTime;
    private OrderStatus status;
    private User user;
    private List<MenuItem> itemList;
    private Double totalPrice;


}


