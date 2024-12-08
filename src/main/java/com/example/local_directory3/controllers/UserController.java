package com.example.local_directory3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.local_directory3.models.User;
import com.example.local_directory3.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Show the registration form
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";  // The name of your registration HTML page
    }

    // Handle the registration form submission
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        // Check if there are validation errors
        if (result.hasErrors()) {
            return "register";  // If validation fails, return to the registration page
        }

        // Save the user to the database
        userService.registerUser(user);
        model.addAttribute("message", "User registered successfully!");

        return "login";  // Redirect to login page after successful registration
    }

    // Show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // The name of your login HTML page
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/businesses";  // Redirect to businesses page on successful login
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";  // Return to the login page on failure
    }
}
