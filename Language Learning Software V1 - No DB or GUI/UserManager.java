/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;


/**
 *
 * @author danny
 */

// imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



// This class manages user registration and logins 
class UserManager 
{
    private List<Lesson> lessons;
    private List<User> users;

    public UserManager() 
    {
        // Initialize lists
        this.users = new ArrayList<>();
        this.lessons = new ArrayList<>();
        // Method called to load registered users
        loadRegisteredUsers();
        // Method called to load lessons for users to learn
        loadLessons(); 
    }

    
    
    // Method to initialize lessons with vocabulary
    private void loadLessons() 
    {
        // Add Hindi lesson
        Lesson hindiLesson = new Lesson("Hindi Vocabulary");
        hindiLesson.addVocabItem(new HindiVocab("Vidyalaya", "School", "Main roz vidyalaya jata hoon."));
        hindiLesson.addVocabItem(new HindiVocab("Ghar", "House", "Yeh mera ghar hai."));
        hindiLesson.addVocabItem(new HindiVocab("Dost", "Friend", "Woh mera dost hai."));
        hindiLesson.addVocabItem(new HindiVocab("Pani", "Water", "Mujhe pani chahiye."));
        hindiLesson.addVocabItem(new HindiVocab("Kitab", "Book", "Meri kitab kahan hai?"));
        lessons.add(hindiLesson);

        // Add Korean lesson
        Lesson koreanLesson = new Lesson("Korean Vocabulary");
        koreanLesson.addVocabItem(new KoreanVocab("Hakgyo", "School", "Naneun maeil hakgyoe gayo."));
        koreanLesson.addVocabItem(new KoreanVocab("Jip", "House", "Jibe ga sijakhaeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Chingu", "Friend", "Geuneun nae chingu yeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Mul", "Water", "Jeoneun muli piryohaeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Chaek", "Book", "Nae chaek eodi isseoyo?"));
        lessons.add(koreanLesson);

        // Add Spanish lesson
        Lesson spanishLesson = new Lesson("Spanish Vocabulary");
        spanishLesson.addVocabItem(new SpanishVocab("Casa", "House", "La casa es grande."));
        spanishLesson.addVocabItem(new SpanishVocab("Escuela", "School", "Voy a la escuela cada día."));
        spanishLesson.addVocabItem(new SpanishVocab("Amigo", "Friend", "Él es mi amigo."));
        spanishLesson.addVocabItem(new SpanishVocab("Agua", "Water", "Yo necesito agua."));
        spanishLesson.addVocabItem(new SpanishVocab("Libro", "Book", "¿Dónde está mi libro?"));
        lessons.add(spanishLesson);
    }

    
    
    
    // registerUsers() method is used to add a new user for the quiz
    public void registerUsers() 
    {
        // prompts user to enter their desired username
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        for (User user : users) 
        {
            if (user.getUsername().equals(username)) 
            {
                // If username already exists, user is prompted to select another one
                System.out.println("This username already exists. Please enter a different one.");
                return;
            }
        }

        // prompts user to enter a password
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // saves users details successfully
        saveUser(username, password);
        System.out.println("User registered successfully!");
    }

    
    
    // This method is used once a user has entered a username and password to register
    // and saves the users details to a file known as users.txt
    public void saveUser(String username, String password) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) 
        {
            writer.write(username + "," + password);
            writer.newLine();
            users.add(new User(username, password)); 
        } 
        catch (IOException e) 
        {
            // If user cannot be saved/registered
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    
    
    // Load users from file
    // Not being currently used, will be implemented when we add a GUI
    private void loadRegisteredUsers() 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length == 2) 
                {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    
    
    // Used to let a user login
    public User loginUser() 
    {
        // 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) 
        {
            if (user.getUsername().equals(username) && user.getUserPassword().equals(password)) 
            {
                System.out.println("Successful login, Hello " + username + "!");
                return user;
            }
        }
        // If username or password is incorrect, login will be unsuccessful
        System.out.println("Invalid login details.");
        return null;
    }

    
    
    // View scores for a desired user. User must be registered
    public void viewUserScores() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the username of the user whose scores you want to view: ");
        String username = scanner.nextLine();

        User user = getByUsername(username);
        if (user != null) 
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(user.getUsername() + "_scores.txt"))) 
            {
                String line;
                System.out.println("\nScores for " + user.getUsername() + ":");
                while ((line = reader.readLine()) != null) 
                {
                    System.out.println(line);
                }
            } 
            catch (IOException e) 
            {
                System.out.println("No scores found for user: " + user.getUsername());
            }
        } 
        else 
        {
            System.out.println("User not found.");
        }
    }

    
    
    private User getByUsername(String username) 
    {
        for (User user : users) 
        {
            if (user.getUsername().equals(username)) 
            {
                return user;
            }
        }
        return null;
    }

    
    // This method is used to allow the user to see all 
    // different words they could get in the quiz
    // as a sort of "lesson" to help them learn
    public void displayAllVocabularies() 
    {
        System.out.println("Select a language to view vocabulary:");
        System.out.println("1. Hindi");
        System.out.println("2. Spanish");
        System.out.println("3. Korean");
        System.out.print("Enter your choice: ");
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
        {
            case 1:
                System.out.println("Hindi Vocabulary:");
                for (Lesson lesson : lessons) 
                {
                    if (lesson.getTitle().equals("Hindi Vocabulary")) 
                    {
                        lesson.displayLesson();
                    }
                }
                break;
            case 2:
                System.out.println("Spanish Vocabulary:");
                for (Lesson lesson : lessons) 
                {
                    if (lesson.getTitle().equals("Spanish Vocabulary")) 
                    {
                        lesson.displayLesson();
                    }
                }
                break;
            case 3:
                System.out.println("Korean Vocabulary:");
                for (Lesson lesson : lessons) 
                {
                    if (lesson.getTitle().equals("Korean Vocabulary")) 
                    {
                        lesson.displayLesson();
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    } 
}
