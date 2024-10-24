/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author danny
 */
import java.util.List;

public abstract class Quiz {
    protected List<Lesson> lessons;

    public Quiz(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    // Abstract method to display the quiz content, forcing subclasses to implement.
    public abstract String showQuiz();
}

