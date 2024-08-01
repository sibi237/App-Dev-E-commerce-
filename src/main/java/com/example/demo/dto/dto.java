package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class dto {

    private Long id;

    @JsonProperty("name")
    private String Name;

    @JsonProperty("email_id")
    private String email;
    
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("confirm_pass")
    private String confirmpass;
}