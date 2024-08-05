package com.example.demo.service;

import com.example.demo.entity.entity;
import com.example.demo.repo.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    
    @Autowired
    private repo entityRepository;

    public entity saveEntity(entity entity) {
        return entityRepository.save(entity);
    }

    public List<entity> findAllEntities() {
        return entityRepository.findAll();
    }

    public Optional<entity> findEntityById(Long id) {
        return entityRepository.findById(id);
    }

    public void deleteEntity(Long id) {
        entityRepository.deleteById(id);
    }
}
