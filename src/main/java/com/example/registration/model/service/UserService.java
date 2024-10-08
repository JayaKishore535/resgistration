package com.example.registration.model.service;

import com.example.registration.model.User;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);
    List<User> getAllUsers(); // Fetch all registered users
}
