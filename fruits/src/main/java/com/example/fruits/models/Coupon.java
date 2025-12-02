package com.example.fruits.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Double discount;
    @Column(name = "usage_limit")
    private Integer usageLimit;
    @Column(name = "usage_count")
    private Integer usageCount;
    private boolean active;
    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;
}
