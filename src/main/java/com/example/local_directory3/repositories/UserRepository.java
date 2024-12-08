package com.example.local_directory3.repositories;

import com.example.local_directory3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // Find user by email
}
