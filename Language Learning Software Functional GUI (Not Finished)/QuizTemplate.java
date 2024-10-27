/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author damnd
 */
import javax.swing.*;

// Abstract class for quiz
abstract class QuizTemplate 
{
    protected int score;

    public QuizTemplate() 
    {
        this.score = 0;
    }

    public abstract void startQuiz();
    
    protected void showScore() 
    {
        JOptionPane.showMessageDialog(null, "Your score: " + score);
    }
}





