package com.example.local_directory3.services;

import com.example.local_directory3.models.User;
import com.example.local_directory3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to register a user
    public void registerUser(User user) {
        userRepository.save(user);  // Save user to the database
    }

    // Method to find a user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);  // Find user by email
    }
}
