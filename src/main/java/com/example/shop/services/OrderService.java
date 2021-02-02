package com.example.shop.services;

import com.example.shop.bll.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersByUserId(long userId);
    void addOrder(Order order);
}
