package com.example.demo.repo;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Product;

public interface SearchRepo extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

	List<Product> findByName(String name);
}

