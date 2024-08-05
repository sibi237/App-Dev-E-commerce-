package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.SearchRepo;

@Service
public class SearchService {

    @Autowired
    private SearchRepo productRepository;

    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}