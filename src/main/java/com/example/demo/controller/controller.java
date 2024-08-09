 package com.example.demo.controller;

import com.example.demo.entity.entity; // Importing the entity class
import com.example.demo.service.service; // Importing the service class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000/") // Allows cross-origin requests from this URL
@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/ent") // Base URL for all endpoints in this controller
public class controller {

    @Autowired
    private service entityService; // Service class for handling business logic

    // Endpoint to create a new entity
    @PostMapping
    public ResponseEntity<entity> createEntity(@RequestBody entity entity) {
        // Save the entity and return a ResponseEntity with the saved entity
        return ResponseEntity.ok(entityService.saveEntity(entity));
    }

    // Endpoint to retrieve all entities
    @GetMapping
    public ResponseEntity<List<entity>> getAllEntities() {
        // Fetch all entities and return a ResponseEntity with the list of entities
        return ResponseEntity.ok(entityService.findAllEntities());
    }

    // Endpoint to retrieve an entity by its ID
    @GetMapping("/{id}")
    public ResponseEntity<entity> getEntityById(@PathVariable Long id) {
        // Fetch the entity by ID
        Optional<entity> entity = entityService.findEntityById(id);
        // Return the entity if present, otherwise return a 404 Not Found response
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing entity
    @PutMapping("/{id}")
    public ResponseEntity<entity> updateEntity(@PathVariable Long id, @RequestBody entity entity) {
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
