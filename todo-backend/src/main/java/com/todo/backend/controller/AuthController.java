package com.todo.backend.controller;

import com.todo.backend.entity.AuthRequest;
import com.todo.backend.modal.AuthResponse;
import com.todo.backend.modal.Response;
import com.todo.backend.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<Response> generateToken(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()
                )
        );
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new Response(new AuthResponse(token), null));

    }
}
