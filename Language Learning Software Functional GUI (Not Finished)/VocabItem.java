/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author damnd
 */
class VocabItem 
{
    private String foreignWord;
    private String englishTranslation;

    public VocabItem(String foreignWord, String englishTranslation) 
    {
        this.foreignWord = foreignWord;
        this.englishTranslation = englishTranslation;
    }

    public String getForeignWord() 
    {
        return foreignWord;
    }

    public String getEnglishTranslation() 
    {
        return englishTranslation;
    }
}




