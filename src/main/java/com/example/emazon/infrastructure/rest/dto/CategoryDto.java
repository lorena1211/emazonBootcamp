package com.example.emazon.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 90)
    private String description;
}
