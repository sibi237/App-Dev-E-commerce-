package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    

    // Endpoint to add a new mobile case

@PostMapping("/addcase")
public ResponseEntity<String> addCase(@RequestParam("file") MultipartFile file,
                                       @RequestParam("name") String name,
                                       @RequestParam("price") String price) {
    try {
        // Save the product details and file
        Product newCase = new Product();
        newCase.setName(name);
        newCase.setPrice(Double.parseDouble(price));
        // Assuming you save the file somewhere
        // e.g., String filePath = saveFile(file);
        // newCase.setImagePath(filePath);
        productService.saveCase(newCase); // Save the new mobile case

        return ResponseEntity.ok("Case added successfully");
    } catch (Exception e) {
        System.err.println("Error adding case: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add case");
    }
}
}
