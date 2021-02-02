package com.example.shop.services;

import com.example.shop.bll.Order;
import com.example.shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(long userId) {
        Order order = new Order();
        order.setUserId(userId);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("userId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Order> example = Example.of(order, customExampleMatcher);

        return orderRepository.findAll(example);
    }
}
