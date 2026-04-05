package com.todo.backend.Service;

import com.todo.backend.entity.Users;
import com.todo.backend.modal.Role;
import com.todo.backend.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer {
    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234")); // Securely store password
                admin.setRole(String.valueOf(Role.ADMIN));

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user1234")); // Securely store password
                admin.setRole(String.valueOf(Role.USER));

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
        };
    }
}
