package com.example.demo.mapper;

import com.example.demo.dto.dto;
import com.example.demo.entity.entity;

public class mapper {

    public static dto mapToEmployeeDto(entity auth){
        return new dto(
                auth.getId(),
                auth.getName(),
                auth.getEmail(),
                auth.getPassword(),
                auth.getConfirmpass()
        );
    }

    public static entity mapToEmployee(dto authdto){
        return new entity(
                authdto.getId(),
                authdto.getName(),
                authdto.getEmail(),
                authdto.getPassword(),
                authdto.getConfirmpass()
        );
    }
}
