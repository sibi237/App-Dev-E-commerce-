package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface SearchRepo extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}