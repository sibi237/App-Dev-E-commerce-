package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty; // For mapping JSON properties
import lombok.AllArgsConstructor; // For generating an all-args constructor
import lombok.Getter; // For generating getters
import lombok.NoArgsConstructor; // For generating a no-args constructor
import lombok.Setter; // For generating setters

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
public class Authdto {

    private Long id; // Unique identifier for the user

    @JsonProperty("name") // Maps this field to the "name" property in JSON
    private String name; // User's name

    @JsonProperty("email") // Maps this field to the "email" property in JSON
    private String email; // User's email address

    @JsonProperty("password") // Maps this field to the "password" property in JSON
    private String password; // User's password

    @JsonProperty("confirmpass") // Maps this field to the "confirmpass" property in JSON
    private String confirmpass; // Confirm password field
}
