package com.example.demo.controller;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.saveOrder(order);
    }
}

