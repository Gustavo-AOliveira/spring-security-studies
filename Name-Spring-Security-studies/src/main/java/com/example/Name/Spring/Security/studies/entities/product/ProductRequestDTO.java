package com.example.Name.Spring.Security.studies.entities.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        @NotBlank(message = "The field name cannot be blank")
        String name,
        @NotNull(message = "The fild price cannot be null")
        Integer price
) {
}
