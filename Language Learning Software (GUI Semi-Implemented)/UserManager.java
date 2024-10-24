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

public class UserManager {
    private List<Lesson> hindiLessons;
    private List<Lesson> spanishLessons;
    private List<Lesson> koreanLessons;

    public UserManager() {
        loadLessons();
    }

    // Load lessons for each language
    private void loadLessons() {
        hindiLessons = new ArrayList<>();
        spanishLessons = new ArrayList<>();
        koreanLessons = new ArrayList<>();

        Lesson hindiLesson = new Lesson("Colors");
        hindiLesson.addVocabItem(new VocabItem("Blue", "Neela"));
        hindiLesson.addVocabItem(new VocabItem("Red", "Laal"));
        hindiLessons.add(hindiLesson);

        Lesson spanishLesson = new Lesson("Animals");
        spanishLesson.addVocabItem(new VocabItem("Dog", "Perro"));
        spanishLesson.addVocabItem(new VocabItem("Cat", "Gato"));
        spanishLessons.add(spanishLesson);

        Lesson koreanLesson = new Lesson("Greetings");
        koreanLesson.addVocabItem(new VocabItem("Hello", "Annyeong"));
        koreanLesson.addVocabItem(new VocabItem("Thank you", "Gamsahamnida"));
        koreanLessons.add(koreanLesson);
    }

    public List<Lesson> getLessons(String language) {
        switch (language.toLowerCase()) {
            case "hindi":
                return hindiLessons;
            case "spanish":
                return spanishLessons;
            case "korean":
                return koreanLessons;
            default:
                throw new IllegalArgumentException("Invalid language selected");
        }
    }
}
