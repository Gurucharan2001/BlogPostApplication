package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    //singleton
    private static ArrayList<Post> POSTS = new ArrayList<>();
    static{
        Post post1 = new Post();
        post1.setTitle("World Wide");
        post1.setBody("Body of post1");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2 = new Post();
        post2.setTitle("Music");
        post2.setBody("Baba tomar darbare sab pagoler khela");
        post2.setDate(new Date());
        POSTS.add(post2);

        Post post3 = new Post();
        post3.setTitle("Game");
        post3.setBody("Pubg ban in India");
        post3.setDate(new Date());
        POSTS.add(post3);

        Post post4 = new Post();
        post4.setTitle("National");
        post4.setBody("COVID-19's vaccine is released in India");
        post4.setDate(new Date());
        POSTS.add(post4);
    }
    public ArrayList<Post> getAllPosts(){
        return POSTS;
    }

    public void createPost(Post newPost) {
        POSTS.add(newPost);
    }
}
