package com.example.local_directory3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "homepage";  // This should match the name of your HTML file without the extension
    }
}
