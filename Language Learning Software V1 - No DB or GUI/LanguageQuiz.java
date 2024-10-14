/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;



/**
 *
 * @author damnd
 */

// imports
import java.io.*;
import java.util.*;
import java.util.Collections; 

class LanguageQuiz 
{
    private final Lesson lesson;

    public LanguageQuiz(Lesson lesson) 
    {
        this.lesson = lesson;
    }

    
    // method called when quiz is started
    public void startQuiz(User user) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting: " + lesson.getTitle());
        user.resetUserScore();

        Collections.shuffle(lesson.getVocabItems());

        for (Vocab item : lesson.getVocabItems()) 
        {
            System.out.println("Translate the following word: " + item.getWord());
            System.out.println("Word used in a sentence: " + item.getExSentence());
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(item.getTranslation())) 
            {
                System.out.println("Correct!");
                user.increaseUserScore();
            } 
            else 
            {
                System.out.println("Incorrect. The answer is: " + item.getTranslation());
            }
        }

        System.out.println("Quiz Complete! Your score is: " + user.getUserScore());
        saveScore(user);
    }

    
    
    // This method is used to save the users score
    private void saveScore(User user) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(user.getUsername() + "_scores.txt", true))) 
        {
            writer.write("Lesson: " + lesson.getTitle() + " - Score: " + user.getUserScore());
            writer.newLine();
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }
}
