package com.example.local_directory3.repositories;

import com.example.local_directory3.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    // JpaRepository provides built-in methods for CRUD operations
}
