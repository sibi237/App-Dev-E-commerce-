package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.dto;
@Service
public interface service {
    dto createEmployee(dto employeeDto);

    dto getEmployeeById(Long employeeId);

    List<dto> getAllEmployees();

    dto updateEmployee(Long employeeId, dto updatedEmployee);

    void deleteEmployee(Long employeeId);
}