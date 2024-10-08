package com.example.registration.model.controller;

import com.example.registration.model.User;
import com.example.registration.model.service.UserService;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;



@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Set all fields
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setGender(user.getGender());
        user.setAddress(user.getAddress());
        user.setAge(user.getAge());
        user.setState(user.getState());
        user.setCountry(user.getCountry());
        User savedUser = userService.save(user);
        Long userId = savedUser.getId();

        model.addAttribute("message", "Registration successful! Your ID is: " + userId);
        model.addAttribute("user", new User()); // Clear the form

        return "register";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}