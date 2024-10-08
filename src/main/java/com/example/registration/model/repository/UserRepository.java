package com.example.registration.model.repository;

import com.example.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}