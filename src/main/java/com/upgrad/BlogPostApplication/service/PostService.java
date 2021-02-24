package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

@Service
public class PostService {
    //singleton
    private static ArrayList<Post> POSTS = new ArrayList<>();
   /* static{
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
    }*/

    private final String url = "jdbc:postgresql://localhost:5432/technicalblog";
    private final String username = "postgres";
    private final String password = "password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    
    public ArrayList<Post> getAllPosts(){
        try{
            //Business logic for connecting the database
            //step1:Connect to the db
            Connection connection = connect();

            //step2: Get/Create the statement
            Statement statement = connection.createStatement();

            //step3:excute the select query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");

            //step4:Loop into the resultSet and get the data
            while(resultSet.next()){
                Post post1 = new Post();
                post1.setTitle(resultSet.getString("title"));
                post1.setBody(resultSet.getString("body"));
                post1.setDate(resultSet.getDate("date"));

                //store the data in the Singleton
                POSTS.add(post1);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return POSTS;
    }

    public void createPost(Post newPost) {
        String query = "INSERT INTO posts(title, body, date) VALUES(?, ?, ?)";
        try {
            // Step 1: Connect to the DB
            Connection connection = connect();

            // Step 2: Prepare a statement
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Step 3: Fix the values from the VIEWS
            preparedStatement.setString(1, newPost.getTitle());
            preparedStatement.setString(2, newPost.getBody());
            preparedStatement.setDate(3, new Date(newPost.getDate().getTime()));

            int updatedRows = preparedStatement.executeUpdate();

            if(updatedRows > 0) {
                System.out.println("Update is working Fine!");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
