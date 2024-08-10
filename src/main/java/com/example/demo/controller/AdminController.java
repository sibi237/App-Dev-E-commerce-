package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminEntity;
import com.example.demo.service.AdminService;

@CrossOrigin("http://localhost:3000/") // Allows cross-origin requests from this URL
@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/admin") // Base URL for all endpoints in this controller
public class AdminController {

    @Autowired
    private AdminService entityService; // Service class for handling business logic

    // Endpoint to create a new entity
    @PostMapping
    public ResponseEntity<AdminEntity> createEntity(@RequestBody AdminEntity entity) {
        // Save the entity and return a ResponseEntity with the saved entity
    	System.out.print("success");
        return ResponseEntity.ok(entityService.saveEntity(entity));
    }

    // Endpoint to retrieve all entities
    @GetMapping
    public ResponseEntity<List<AdminEntity>> getAllEntities() {
        // Fetch all entities and return a ResponseEntity with the list of entities
        return ResponseEntity.ok(entityService.findAllEntities());
    }

    // Endpoint to retrieve an entity by its ID
    @GetMapping("/{id}")
    public ResponseEntity<AdminEntity> getEntityById(@PathVariable Long id) {
        // Fetch the entity by ID
        Optional<AdminEntity> entity = entityService.findEntityById(id);
        // Return the entity if present, otherwise return a 404 Not Found response
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing entity
    @PutMapping("/{id}")
    public ResponseEntity<AdminEntity> updateEntity(@PathVariable Long id, @RequestBody AdminEntity entity) {
        // Check if the entity with the given ID exists
        if (!entityService.findEntityById(id).isPresent()) {
            // Return 404 Not Found if the entity does not exist
            return ResponseEntity.notFound().build();
        }
        // Set the ID of the entity to the path variable ID
        entity.setId(id);
        // Save the updated entity and return a ResponseEntity with the updated entity
        return ResponseEntity.ok(entityService.saveEntity(entity));
    }

    // Endpoint to delete an entity by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        // Check if the entity with the given ID exists
        if (!entityService.findEntityById(id).isPresent()) {
            // Return 404 Not Found if the entity does not exist
            return ResponseEntity.notFound().build();
        }
        // Delete the entity and return a 204 No Content response
        entityService.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}