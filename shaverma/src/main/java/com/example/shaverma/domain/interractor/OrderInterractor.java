package com.example.shaverma.domain.interractor;

import com.example.shaverma.domain.model.Order;
import com.example.shaverma.domain.enums.OrderStatus;
import com.example.shaverma.domain.model.User;
import com.example.shaverma.domain.repo.OrderRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderInterractor{

    private final OrderRepo orderRepo;

    public Order createOrder(Order order){
        return orderRepo.saveOrder(order);
    }

    public Order changeOrder(Order order){
        return orderRepo.updateOrder(order);
    }

    public List<Order> getOrdersByUser(User user){
        return orderRepo.getOrdersByUser(user);
    }

    public List<Order> getOrdersByStatus(OrderStatus status){
        return orderRepo.getOrdersByStatus(status);
    }

}

