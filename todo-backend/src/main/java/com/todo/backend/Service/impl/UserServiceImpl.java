package com.todo.backend.Service.impl;

import com.todo.backend.Service.UserService;
import com.todo.backend.entity.Users;
import com.todo.backend.model.Role;
import com.todo.backend.model.UserRegistrationRequest;
import com.todo.backend.model.UserRegistrationResponse;
import com.todo.backend.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        validateUserRequest(userRegistrationRequest);
        Users users = new Users();
        users.setUsername(userRegistrationRequest.getUsername());
        users.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        users.setRole(Role.USER);
        Users registeredUser = userDetailsRepository.save(users);
        log.info("User has been registered successfully");
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setId(registeredUser.getId());
        userRegistrationResponse.setUsername(registeredUser.getUsername());
        userRegistrationResponse.setRole(registeredUser.getRole());
        return userRegistrationResponse;
    }

    private void validateUserRequest(UserRegistrationRequest userRegistrationRequest) {
        log.info("Validating user registration request");
        if( null == userRegistrationRequest) {
            throw new RuntimeException("User details is empty");
        }
        if(null == userRegistrationRequest.getPassword() || null == userRegistrationRequest.getUsername()) {
            throw new RuntimeException("Username or password is null");
        }
    }
}
