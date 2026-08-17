package org.example.fooddeliverysystem.service;

import org.example.fooddeliverysystem.dto.LoginUserDto;
import org.example.fooddeliverysystem.dto.RegisterUserDto;
import org.example.fooddeliverysystem.dto.UserRequest;
import org.example.fooddeliverysystem.entity.User;
import org.example.fooddeliverysystem.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class  AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    public User signUp(UserRequest input) {
        User user = new User();

                user.setName(input.getName());
                user.setEmailId(input.getEmailId());
        user.setAge(input.getAge());

        user.setAddress(input.getAddress());
        user.setGender(input.getGender());
        user.setRole(input.getRole());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmailId(),
                        input.getPassword()));
        return userRepository.findByEmailId(input.getEmailId()).orElseThrow();
    }
}

