package com.springboot.studentmanagement.dto;

public record StudentDto(
        Long id,
        String name,
        String surname,
        String email
) {
}
