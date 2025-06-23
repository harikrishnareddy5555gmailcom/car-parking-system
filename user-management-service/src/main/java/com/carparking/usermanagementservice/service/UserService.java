package com.carparking.usermanagementservice.service;

import com.carparking.usermanagementservice.entity.User;
import com.carparking.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User registerUser(User user) {
        return repository.save(user);
    }

    public User getUser(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}