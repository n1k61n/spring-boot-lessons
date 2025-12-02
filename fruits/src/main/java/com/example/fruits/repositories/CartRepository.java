package com.example.fruits.repositories;

import com.example.fruits.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart, Long> {
 
}