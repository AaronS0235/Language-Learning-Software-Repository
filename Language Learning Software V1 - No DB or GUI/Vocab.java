/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;

/**
 *
 * @author damnd
 */
abstract class Vocab 
{
    // Defining fields 
    protected String word;
    protected String translation;
    protected String exSentence;

    public Vocab(String word, String translation, String exSentence) 
    {
        this.word = word;
        this.translation = translation;
        this.exSentence = exSentence;
    }

    // Getters and setters
    public String getWord() 
    {
        return word;
    }

    
    public String getTranslation() 
    {
        return translation;
    }

    
    public String getExSentence() 
    {
        return exSentence;
    }

    
    public void setWord(String word) 
    {
        this.word = word;
    }

    
    public void setTranslation(String translation) 
    {
        this.translation = translation;
    }

    
    public void setExSentence(String exampleSentence) 
    {
        this.exSentence = exSentence;
    }

    
    // Abstract method used to display vocab details
    public abstract void display();
}
