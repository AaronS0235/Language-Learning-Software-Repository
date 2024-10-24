/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

import java.util.List;

/**
 *
 * @author danny
 */
public class SpanishQuiz extends Quiz {
    public SpanishQuiz(List<Lesson> lessons) {
        super(lessons);
    }

    @Override
    public String showQuiz() {
        StringBuilder quizContent = new StringBuilder("Spanish Quiz:\n");
        for (Lesson lesson : lessons) {
            quizContent.append("\n").append(lesson.getTitle()).append(":\n");
            for (VocabItem item : lesson.getVocabItems()) {
                quizContent.append(item.getEnglishWord()).append(" - ")
                           .append(item.getTranslatedWord()).append("\n");
            }
        }
        return quizContent.toString();
    }
}

