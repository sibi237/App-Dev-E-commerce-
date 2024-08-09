package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.Product;
import com.example.demo.repo.OrderRepository;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity saveOrder(OrderEntity pro) {
        return orderRepository.save(pro);
    }

    public Optional<OrderEntity> findByName(String name) {
        return orderRepository.findByName(name);
    }

//	public OrderEntity getOrderById(Long id) {
//		return orderRepository.getOrderById(id);
//	}
}
