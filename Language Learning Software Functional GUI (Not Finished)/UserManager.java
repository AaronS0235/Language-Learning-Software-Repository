/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author damnd
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager 
{
    private static final String USERS_FILE = "users.txt";
    private List<User> users;

    public UserManager() 
    {
        users = loadUsers();
    }

    
    public boolean login(String username, String password) 
    {
        for (User user : users) 
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) 
            {
                return true;
            }
        }
        return false;
    }

    
    public void registerUser(String username, String password) 
    {
        users.add(new User(username, password));
        saveUsers();
    }

    
    private List<User> loadUsers() 
    {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length == 2) 
                {
                    userList.add(new User(parts[0], parts[1]));
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return userList;
    }

    
    private void saveUsers() 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) 
        {
            for (User user : users) 
            {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}

