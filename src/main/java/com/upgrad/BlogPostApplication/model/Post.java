package com.upgrad.BlogPostApplication.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

//pojo->plain old java object
@Entity
@Table(name = "posts")
public class Post {
    //components of the post
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "date")
    private Date date;

    //getter and setter for

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
