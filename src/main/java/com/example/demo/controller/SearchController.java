package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private SearchService searchService;
    @GetMapping("/api/Search/search")
    public ResponseEntity<List<Product>> getProducts(@RequestParam String name) {
        List<Product> products = searchService.findByName(name);
//        if (products.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(products);
    }
}
