package com.example.shop.controllers;


import com.example.shop.bll.Order;
import com.example.shop.bll.Product;
import com.example.shop.bll.ProductType;
import com.example.shop.bll.User;
import com.example.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("orders")
    public ResponseEntity<?> addUser(@RequestBody Order order) {
        orderService.addOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("orders")
    public List<Order> getOrdersByUserId(@RequestParam long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return orders;
    }
}
