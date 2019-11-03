package com.licenta.ContactBook.service;

import com.licenta.ContactBook.model.User;
import com.licenta.ContactBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void addUser(User newUser) {
        userRepository.save(newUser);
    }
}
