package com.example.demo.impl;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.demo.dto.dto;
import com.example.demo.entity.entity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.mapper;
import com.example.demo.repo.repo;
import com.example.demo.service.service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class impl implements service {

    private repo employeeRepository;

    @Override
    public dto createEmployee(dto signupdto) {

        entity employee = mapper.mapToEmployee(signupdto);
        entity savedEmployee = employeeRepository.save(employee);
        return mapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public dto getEmployeeById(Long signupId) {
        entity employee = employeeRepository.findById(signupId)
        		.orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + signupId));

        return mapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<dto> getAllEmployees() {
        List<entity> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> mapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public dto updateEmployee(Long Id, dto updated) {

        entity employee = employeeRepository.findById(Id).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + Id)
        );

        employee.setName(updated.getName());
        employee.setEmail(updated.getEmail());
        

       entity updatedEmployeeObj = employeeRepository.save(employee);

        return mapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long Id) {

        entity employee = employeeRepository.findById(Id).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + Id)
        );

        employeeRepository.deleteById(Id);
    }
}
