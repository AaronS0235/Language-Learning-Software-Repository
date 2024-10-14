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
import java.util.*;

class Lesson 
{
    private String title;
    private List<Vocab> vocabItems;

    
    // Constructor
    public Lesson(String title) 
    {
        this.title = title;
        this.vocabItems = new ArrayList<>();
    }

    
    // used to add a word to the vocabulary
    public void addVocabItem(Vocab item) 
    {
        vocabItems.add(item);
    }
    
    
    public String getTitle() 
    {
        return title;
    }

    

    
    public List<Vocab> getVocabItems() 
    {
        return vocabItems;
    }

    // Used to display lesson
    public void displayLesson() 
    {
        System.out.println("Lesson: " + title);
        for (Vocab item : vocabItems) 
        {
            item.display();
        }
    }
}