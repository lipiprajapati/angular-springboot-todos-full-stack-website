package com.todo.backend.model;

import lombok.Data;

@Data
public class UserRegistrationResponse {
    private Long id;
    private String username;
    private Role role;
}
