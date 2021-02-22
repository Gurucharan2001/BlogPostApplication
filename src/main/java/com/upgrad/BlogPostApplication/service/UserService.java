package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(User user){
        if(user.getUsername().equals("Gurucharan") && user.getPassword().equals("Guru@2001")){
            return true;
        }else{
            return false;
        }
    }
}
