/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;

/**
 *
 * @author danny
 */
import java.io.*;
import java.util.*;


// User class
public class User 
{
    // Defining fields
    private String username; // User's username
    private String password; // User's password
    private int userScore; // User's score

    // constructor
    public User(String username, String password) 
    {
        this.username = username;
        this.password = password;
        this.userScore = 0;
    }
    
    // Getters and Setters
    public String getUsername() 
    {
        return username;
    }

    public String getUserPassword() 
    {
        return password;
    }

    public int getUserScore() 
    {
        return userScore;
    }

   
    // Method used to increase the users score everytime they score a point
    public void increaseUserScore() 
    {
        userScore++;
    }

    //Method used to reset the score of a user at the end of a quiz
    public void resetUserScore() 
    {
        this.userScore = 0;
    }
}
