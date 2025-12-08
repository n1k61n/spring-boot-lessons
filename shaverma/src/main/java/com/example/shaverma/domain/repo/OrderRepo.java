package com.example.shaverma.domain.repo;

import com.example.shaverma.domain.model.Order;
import com.example.shaverma.domain.enums.OrderStatus;
import com.example.shaverma.domain.model.User;

import java.util.List;

public interface OrderRepo{
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    List<Order> getOrdersByUser(User user);
    List<Order> getOrdersByStatus(OrderStatus status);
}


