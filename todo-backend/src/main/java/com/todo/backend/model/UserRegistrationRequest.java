package com.todo.backend.model;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String username;
    private String password;
    private Role role;
}
