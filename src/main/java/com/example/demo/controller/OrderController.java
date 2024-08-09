package com.example.demo.controller;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{id}")
//    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
//        OrderEntity order = orderService.getOrderById(id);
//        if (order != null) {
//            return ResponseEntity.ok(order);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
