package com.todo.backend.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class BasicAuthenticatiionController {
 
	@GetMapping(path="/basicauth")
	public AuthenticationBean authBean() {
		return new AuthenticationBean("you are authenticated");
	}
}
