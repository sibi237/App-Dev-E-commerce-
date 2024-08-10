package com.example.demo.entity;

import jakarta.persistence.*; // Import JPA annotations
import lombok.AllArgsConstructor; // For generating an all-args constructor
import lombok.Getter; // For generating getters
import lombok.NoArgsConstructor; // For generating a no-args constructor
import lombok.Setter; // For generating setters

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
@Entity // Marks this class as a JPA entity
@Table(name = "admin") // Maps this entity to the "auth" table in the database
public class AdminEntity {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates values for the primary key
    private Long id;


    @Column(name = "email") // Maps this field to the "email" column in the table
    private String email;

    @Column(name = "password") // Maps this field to the "password" column in the table
    private String password;

//    @Column(name = "name") // Maps this field to the "name" column in the table
//    private String name;	
    
//    @Column(name = "confirmpass") // Maps this field to the "confirmpass" column in the table
//    private String confirmpass;
}
