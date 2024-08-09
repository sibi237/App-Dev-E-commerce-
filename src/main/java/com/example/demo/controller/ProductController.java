package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/products") // Base URL for product-related endpoints
@CrossOrigin(origins = "http://localhost:3000") // connect with springboot]]
public class ProductController {

    @Autowired
    private ProductService productService; // creating object for productService
    
    // Endpoint to retrieve all products
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts(); // Fetches all products and returns them
    }

    // Endpoint to retrieve a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id); // Fetches product by ID
        if (product == null) {
            return ResponseEntity.notFound().build(); // Returns 404 Not Found if the product is not found
        }
        return ResponseEntity.ok(product); // Returns the found product with a 200 OK status
    }
}
