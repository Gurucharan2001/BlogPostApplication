package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public boolean login(User user){
        if(user.getUsername().equals("Gurucharan") && user.getPassword().equals("Guru@2001")){
            return true;
        }else{
            return false;
        }
       // userRepository.login(user);
    }
    public void registerUser(User newUser){
        userRepository.registerUser(newUser);
    }
}
