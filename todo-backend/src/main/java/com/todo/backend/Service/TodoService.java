package com.todo.backend.Service;

import com.todo.backend.modal.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAll();
    public Todo save(Todo todo);
    public Todo deleteById(long id);
    public Todo findById(long id);
}
