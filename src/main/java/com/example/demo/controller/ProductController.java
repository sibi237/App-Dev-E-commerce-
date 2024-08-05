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

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
      Product product = productService.getProductById(id);
      if (product == null) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(product);
}
}


//@RestController
//@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React app
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Product product = productService.getProductById(id);
//        if (product == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(product);
//    }
//}
