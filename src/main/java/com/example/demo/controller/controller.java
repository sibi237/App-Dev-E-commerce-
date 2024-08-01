package com.example.demo.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.dto;
import com.example.demo.service.service;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/prime")

public class controller {
	@Autowired
    private service signupService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<dto> createEmployee(@RequestBody dto signupDto){
        dto savedEmployee = signupService.createEmployee(signupDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<dto> getEmployeeById(@PathVariable("id") Long signupId){
        dto employeeDto = signupService.getEmployeeById(signupId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<dto>> getAllEmployees(){
        List<dto> employees = signupService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<dto> updateEmployee(@PathVariable("id") Long signupId,
                                                      @RequestBody dto updatedEmployee){
          dto employeeDto = signupService.updateEmployee(signupId, updatedEmployee);
          return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        signupService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
