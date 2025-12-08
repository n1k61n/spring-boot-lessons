package com.example.shaverma.data.repoImpls.collectionFrw;

import com.example.shaverma.domain.enums.OrderStatus;
import com.example.shaverma.domain.model.Order;
import com.example.shaverma.domain.model.User;
import com.example.shaverma.domain.repo.OrderRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepoImpl implements OrderRepo {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, order);
        }
        return order;
    }


    @Override
    public List<Order> getOrdersByUser(User user) {
        return orders.stream()
                .filter(order -> order.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orders.stream()
                .filter(order -> order.getStatus().name().equals(status.name()))
                .collect(Collectors.toList());

    }
}
