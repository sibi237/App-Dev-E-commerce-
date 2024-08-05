package com.example.demo.controller;


import com.example.demo.entity.entity;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/ent")
public class controller {

    @Autowired
    private service entityService;

    @PostMapping
    public ResponseEntity<entity> createEntity(@RequestBody entity entity) {
        return ResponseEntity.ok(entityService.saveEntity(entity));
    }

    @GetMapping
    public ResponseEntity<List<entity>> getAllEntities() {
        return ResponseEntity.ok(entityService.findAllEntities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<entity> getEntityById(@PathVariable Long id) {
        Optional<entity> entity = entityService.findEntityById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<entity> updateEntity(@PathVariable Long id, @RequestBody entity entity) {
        if (!entityService.findEntityById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        entity.setId(id);
        return ResponseEntity.ok(entityService.saveEntity(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        if (!entityService.findEntityById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        entityService.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }
}
