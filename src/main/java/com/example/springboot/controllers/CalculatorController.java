package com.example.springboot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    private final List<User> users = new ArrayList<>();

    @GetMapping("/add")
    public double add(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2") double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2") double num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2") double num2) {
        return num1 * num2;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2") double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return 0.0;
        }
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to homepage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        users.add(user);
        return "redirect:/login";
    }
}

class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
