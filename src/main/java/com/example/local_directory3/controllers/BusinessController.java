package com.example.local_directory3.controllers;

import com.example.local_directory3.models.Business;
import com.example.local_directory3.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    // Display all businesses
    @GetMapping
    public String listBusinesses(Model model) {
        model.addAttribute("businesses", businessService.getAllBusinesses());
        return "businesses"; // Displays all businesses
    }

    // Display the form to add a new business
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("business", new Business()); // For the form
        return "addbusiness"; // Page to add a business
    }

    // Save new business to the database
    @PostMapping("/add")
    public String addBusiness(@ModelAttribute Business business) {
        businessService.saveBusiness(business);
        return "redirect:/businesses"; // Redirect back to business list
    }

    // Show the edit form for a specific business
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Business business = businessService.getBusinessById(id); // Fetch the business by ID
        model.addAttribute("business", business); // Add to model for form
        return "editbusiness"; // Edit business page
    }

    // Update business details
    @PostMapping("/edit/{id}")
    public String updateBusiness(@PathVariable("id") Long id, @ModelAttribute Business business) {
        business.setId(id); // Ensure the ID is preserved
        businessService.saveBusiness(business); // Save updated business
        return "redirect:/businesses"; // Redirect back to the list
    }

    // Delete a business
    @GetMapping("/delete/{id}")
    public String deleteBusiness(@PathVariable("id") Long id) {
        businessService.deleteBusiness(id); // Delete the business by ID
        return "redirect:/businesses"; // Redirect back to the business list
    }
}
