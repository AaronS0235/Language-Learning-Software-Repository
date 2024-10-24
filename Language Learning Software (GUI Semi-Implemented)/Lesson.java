/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author danny
 */
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String title;
    private List<VocabItem> vocabItems;

    public Lesson(String title) {
        this.title = title;
        this.vocabItems = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<VocabItem> getVocabItems() {
        return vocabItems;
    }

    public void addVocabItem(VocabItem item) {
        vocabItems.add(item);
    }
}

