package com.example.demo.repo;

import com.example.demo.entity.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends JpaRepository<entity, Long> {
}
