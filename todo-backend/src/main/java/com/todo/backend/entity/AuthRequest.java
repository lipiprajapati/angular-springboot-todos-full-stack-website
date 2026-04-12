package com.todo.backend.entity;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
