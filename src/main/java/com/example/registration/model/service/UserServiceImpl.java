package com.example.registration.model.service;

import com.example.registration.model.User;
import com.example.registration.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user); // Save the user to the database
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}