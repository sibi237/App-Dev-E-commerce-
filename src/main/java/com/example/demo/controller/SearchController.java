package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.SearchService;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class SearchController {

    @Autowired
    private SearchService productService;

    @GetMapping("/api/search")
    public List<Product> getProducts(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return productService.findByNameContaining(name);
        }
        return productService.getAllProducts();
    }
}