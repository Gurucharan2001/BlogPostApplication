package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.repository.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class PostService {
    //singleton
   // private static ArrayList<Post> POSTS = new ArrayList<>();

    //step 1:Create EntityManagerFactory

    @Autowired
    private postRepository postRepository;


    public List<Post> getAllPosts(Integer userId){
        return postRepository.getAllPosts(userId);
    }

    public void createPost(Post newPost){
        postRepository.createPost(newPost);
    }

    public Post getPost(Integer postId){
        return postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        postRepository.deletePost(postId);
    }

}
