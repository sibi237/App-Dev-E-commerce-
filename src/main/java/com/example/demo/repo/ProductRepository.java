package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Inherits CRUD operations and additional methods from JpaRepository
}
