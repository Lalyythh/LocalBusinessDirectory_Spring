package com.example.local_directory3.services;

import com.example.local_directory3.models.Business;
import com.example.local_directory3.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    // Save or update a business
    public void saveBusiness(Business business) {
        businessRepository.save(business);
    }

    // Get all businesses
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    // Get business by ID
    public Business getBusinessById(Long id) {
        Optional<Business> business = businessRepository.findById(id);
        return business.orElse(null); // Return null if not found
    }

    // Delete a business
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }
}
