package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.service.PostService;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService = new UserService();
    private PostService postService = new PostService();

    //GET request to /users/login
    @RequestMapping(method = RequestMethod.GET,value = "/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/users/login";
    }
    //POST request to /users/login
    @RequestMapping(method = RequestMethod.POST,value = "/users/login")
    public String loginUser(User user){
        //check if credentials are match
        if(userService.login(user)){
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }
//for ui
    @RequestMapping(method = RequestMethod.GET,value = "/users/registration")
    public String registration(User user){
        return "/users/registration";
    }
   //for store the data
    @RequestMapping(method = RequestMethod.POST,value = "/users/registration")
    public String userRegistration(User user){
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "redirect:/";
    }



}
