package com.todo.backend.Service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.todo.backend.model.Todo;
import com.todo.backend.Service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
	
	//Here hard coded data are used. In the real time we will get data by a database.
	private static final List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter, "Hitesh", "Learn to Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "Susmita", "Learn to SpringBoot", new Date(), true));
		todos.add(new Todo(++idCounter, "Susmita", "Make project on C", new Date(), true));
		todos.add(new Todo(++idCounter, "Ayan", "Learn Java", new Date(), true));
		todos.add(new Todo(++idCounter, "Yuvansh", "Angular hands on practice", new Date(), false));
		todos.add(new Todo(++idCounter, "Yuvansh", "Java hands on practice", new Date(), true));
	}
	
	public List<Todo> getAll(){
		return todos;
	}
	
	public Todo save(Todo todo){
		if(todo.getId() == -1 || todo.getId() ==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	
	public Todo deleteById(long id){
		Todo todo =  findById(id);
		if(todo == null) return null;
		
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo: todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}


}
