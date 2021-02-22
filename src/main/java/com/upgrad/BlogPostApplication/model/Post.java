package com.upgrad.BlogPostApplication.model;

import java.util.Date;

//pojo->plain old java object
public class Post {
    //components of the post
    private String title;
    private String body;
    private Date date;

    //getter and setter for
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
