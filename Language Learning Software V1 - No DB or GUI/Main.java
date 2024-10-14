/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;


/**
 *
 * @author damnd
 */

// Imports needed
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class which runs main method
public class Main 
{
    // Main method
    public static void main(String[] args) 
    {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        // Language quiz start
        System.out.println("Welcome to this software language learning program/quiz!");

        // Initial menu
        while (true) 
        {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. View User Scores");
            System.out.println("4. View All Vocabulary Words");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Take in user input
            int usersChoice;
            try 
            {
                usersChoice = scanner.nextInt();
                scanner.nextLine(); 
            } 
            
            // if user input is invalid
            catch (InputMismatchException e) 
            {
                // Prompt user to enter a valid choice
                System.out.println("Invalid choice. Please enter a number (1, 2, 3, 4, or 5).");
                scanner.nextLine(); 
                // restart loop so user can enter a different answer
                continue; 
            }

            // Generate different output depending on what user enters
            switch (usersChoice) 
            {
                case 1:
                    // Case 1: method is called to register users, asks for username and password and saves to file
                    userManager.registerUsers();
                    break;
                case 2:
                    // Case 2: method is called to let user log in, asks for username and password
                    User loggedInUser = userManager.loginUser();
                    if (loggedInUser != null) 
                    {
                        userMenu(loggedInUser, userManager);
                    }
                    break;
                case 3:
                    // Case 3: Allows user to view the scores of a specified user
                    userManager.viewUserScores();
                    break;
                case 4:
                    // Case 4: Option to view all words in the vocabulary and their translations as well as the use of the word
                    // in a sentence
                    userManager.displayAllVocabularies();
                    break;
                case 5:
                    // Case 5: Exits program
                    System.out.println("Exiting quiz...");
                    return;
                default:
                    System.out.println("Input is not valid. Please try again.");
                    break;
            }
        }
    }

    // For new display menu after user logs in
    private static void userMenu(User user, UserManager userManager) 
    {
        // New scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean keepLoggedIn = true;

        while (keepLoggedIn) 
        {
            System.out.println("\nLogged in as: " + user.getUsername());
            System.out.println("1. Start a new quiz");
            System.out.println("2. Return to the main menu");
            System.out.print("Enter your choice: ");

            // Recieve user input
            int userChoice = scanner.nextInt();
            scanner.nextLine(); 

            // Switch used to generate different output depending on what user selected
            switch (userChoice) 
            {
                case 1:
                    // start new quiz
                    chooseLanguage(user, userManager);
                    break;
                case 2:
                    // return to main menu/log out
                    keepLoggedIn = false;
                    break;
                default:
                    // Prompt user to enter valid choice in case of
                    // invalid entry
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void chooseLanguage(User user, UserManager userManager) 
    {
        // New scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean continueLanguageQuiz = true;

        while (continueLanguageQuiz) 
        {
            System.out.println("\nSelect the language you want to learn:");
            System.out.println("1. Hindi");
            System.out.println("2. Spanish");
            System.out.println("3. Korean");
            System.out.println("4. Return to the user menu");
            System.out.print("Enter your choice: ");

            int languageChoice = scanner.nextInt();
            scanner.nextLine(); 

            Lesson selectedLesson = null;
            switch (languageChoice) 
            {
                case 1:
                    // Starts hindi lesson
                    selectedLesson = createHindiLesson();
                    break;
                case 2:
                    // starts spanish lesson
                    selectedLesson = createSpanishLesson();
                    break;
                case 3:
                    // starts korean lesson
                    selectedLesson = createKoreanLesson();
                    break;
                case 4:
                    continueLanguageQuiz = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid choice (between 1-4).");
                    continue;
            }

            if (selectedLesson != null) 
            {
                LanguageQuiz quiz = new LanguageQuiz(selectedLesson);
                quiz.startQuiz(user);
            }
        }
    }

    // all the different words that are saved here for each language
    // the order the user receives these words in the quiz is randomized
    
    // Hindi words
    private static Lesson createHindiLesson() 
    {
        Lesson hindiLesson = new Lesson("Hindi Vocabulary");
        hindiLesson.addVocabItem(new HindiVocab("Vidyalaya", "School", "Main roz vidyalaya jata hoon."));
        hindiLesson.addVocabItem(new HindiVocab("Ghar", "House", "Yeh mera ghar hai."));
        hindiLesson.addVocabItem(new HindiVocab("Dost", "Friend", "Woh mera dost hai."));
        hindiLesson.addVocabItem(new HindiVocab("Pani", "Water", "Mujhe pani chahiye."));
        hindiLesson.addVocabItem(new HindiVocab("Kitab", "Book", "Meri kitab kahan hai?"));
        return hindiLesson;
    }
    
    // Korean words
    private static Lesson createKoreanLesson() 
    {
        Lesson koreanLesson = new Lesson("Korean Vocabulary");
        koreanLesson.addVocabItem(new KoreanVocab("Hakgyo", "School", "Naneun maeil hakgyoe gayo."));
        koreanLesson.addVocabItem(new KoreanVocab("Jip", "House", "Jibe ga sijakhaeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Chingu", "Friend", "Geuneun nae chingu yeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Mul", "Water", "Jeoneun muli piryohaeyo."));
        koreanLesson.addVocabItem(new KoreanVocab("Chaek", "Book", "Nae chaek eodi isseoyo?"));
        return koreanLesson;
    }
    
    // Spanish words
    private static Lesson createSpanishLesson() 
    {
        Lesson spanishLesson = new Lesson("Spanish Vocabulary");
        spanishLesson.addVocabItem(new SpanishVocab("Casa", "House", "La casa es grande."));
        spanishLesson.addVocabItem(new SpanishVocab("Escuela", "School", "Voy a la escuela cada día."));
        spanishLesson.addVocabItem(new SpanishVocab("Amigo", "Friend", "Él es mi amigo."));
        spanishLesson.addVocabItem(new SpanishVocab("Agua", "Water", "Yo necesito agua."));
        spanishLesson.addVocabItem(new SpanishVocab("Libro", "Book", "¿Dónde está mi libro?"));
        return spanishLesson;
    }
}


                
              