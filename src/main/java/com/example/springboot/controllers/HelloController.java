package com.example.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/calculator")
public class HelloController {

    @GetMapping("/add")
    public double add(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2")double num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract")
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply")
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @GetMapping("/divide")
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return 0.0;
        }
    }
}

