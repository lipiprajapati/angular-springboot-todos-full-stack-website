package com.todo.backend.model;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    USER(Set.of(Permissions.TODO_READ, Permissions.TODO_DELETE, Permissions.TODO_WRITE)),
    ADMIN(Set.of(Permissions.TODO_READ, Permissions.TODO_WRITE));

    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

}
