package com.todo.backend.Service;

import com.todo.backend.model.UserRegistrationRequest;
import com.todo.backend.model.UserRegistrationResponse;

public interface UserService {
    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
}
