package com.todo.backend.controller;

import java.net.URI;
import java.util.List;

import com.todo.backend.Service.impl.TodoServiceImpl;
import com.todo.backend.model.ApiResponse;
import com.todo.backend.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired 
	private TodoServiceImpl todoServiceImpl;
	
	@GetMapping("/todos")
	public ResponseEntity<ApiResponse<List<Todo>>> getAllTodos(){
		return ResponseEntity.ok(ApiResponse.success(todoServiceImpl.getAll()));
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable long id,  @RequestBody  Todo todo){
		Todo updatedTodo = todoServiceImpl.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Void> insertTodo(@RequestBody  Todo todo){
		Todo creattedTodo = todoServiceImpl.save(todo);
		//get current resource URL & append
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creattedTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id){
		Todo todo = todoServiceImpl.deleteById(id);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
