/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment1_sem2;

/**
 *
 * @author damnd
 */

// Class used to define details of Hindi Vocabulary
public class HindiVocab extends Vocab 
{
    public HindiVocab(String word, String translation, String exSentence) 
    {
        super(word, translation, exSentence);
    }

    //Used to display Hindi words
    @Override
    public void display() 
    {
        System.out.println("Word: " + word);
        System.out.println("Translation: " + translation);
        System.out.println("Word used in a sentence: " + exSentence);
    }
}

