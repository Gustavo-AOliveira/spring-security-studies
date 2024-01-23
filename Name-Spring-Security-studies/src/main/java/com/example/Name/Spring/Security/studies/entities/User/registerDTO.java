package com.example.Name.Spring.Security.studies.entities.User;

public record registerDTO(
        String login,
        String password,
        UserRole role
) {
}
