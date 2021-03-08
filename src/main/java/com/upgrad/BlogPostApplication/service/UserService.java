package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public User login(User user){
        User existingUser = userRepository.checkCredentials(user.getUsername(),user.getPassword());
        if(existingUser == null){
            return null;
        }
        else{
            return existingUser;
        }

    }
    public void registerUser(User newUser){
        userRepository.registerUser(newUser);
    }
}
