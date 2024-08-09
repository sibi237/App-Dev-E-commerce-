package com.example.demo.repo;

import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // Method to find a product by its name
    Optional<OrderEntity> findByName(String name);
}
