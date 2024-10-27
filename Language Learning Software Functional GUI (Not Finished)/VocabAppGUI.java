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
import java.util.ArrayList;
import java.util.List;

public class VocabAppGUI 
{
    private List<VocabItem> hindiVocab;
    private List<VocabItem> koreanVocab;
    private List<VocabItem> spanishVocab;

    public VocabAppGUI() 
    {
        // Example vocabulary lists
        hindiVocab = new ArrayList<>();
        hindiVocab.add(new VocabItem("Namaste", "Hello"));
        hindiVocab.add(new VocabItem("Dhanyavaad", "Thank you"));
        hindiVocab.add(new VocabItem("Aap kaise hain?", "How are you?"));
        hindiVocab.add(new VocabItem("Namaste, aap kaise hain?", "Hello, how are you?"));

        koreanVocab = new ArrayList<>();
        koreanVocab.add(new VocabItem("Annyeonghaseyo", "Hello"));
        koreanVocab.add(new VocabItem("Gamsahabnida", "Thank you"));
        koreanVocab.add(new VocabItem("Eotteohge jinaeseyo?", "How are you?"));
        koreanVocab.add(new VocabItem("Annyeonghaseyo, eotteohge jinaeseyo?", "Hello, how are you?"));

        spanishVocab = new ArrayList<>();
        spanishVocab.add(new VocabItem("Hola", "Hello"));
        spanishVocab.add(new VocabItem("Gracias", "Thank you"));
        spanishVocab.add(new VocabItem("Cómo estás?", "How are you?"));
        spanishVocab.add(new VocabItem("Hola, cómo estás?", "Hello, how are you?"));

        setupGUI();
    }

    private void setupGUI() 
    {
        JFrame frame = new JFrame("Vocabulary Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel label = new JLabel("Choose a language for the quiz:");
        label.setBounds(50, 30, 300, 30);
        frame.add(label);

        JButton hindiButton = new JButton("Hindi Quiz");
        hindiButton.setBounds(50, 70, 150, 30);
        hindiButton.addActionListener(e -> 
        {
            HindiQuiz quiz = new HindiQuiz(hindiVocab);
            quiz.startQuiz();
        });
        frame.add(hindiButton);

        JButton koreanButton = new JButton("Korean Quiz");
        koreanButton.setBounds(50, 110, 150, 30);
        koreanButton.addActionListener(e -> 
        {
            KoreanQuiz quiz = new KoreanQuiz(koreanVocab);
            quiz.startQuiz();
        });
        frame.add(koreanButton);

        JButton spanishButton = new JButton("Spanish Quiz");
        spanishButton.setBounds(50, 150, 150, 30);
        spanishButton.addActionListener(e -> 
        {
            SpanishQuiz quiz = new SpanishQuiz(spanishVocab);
            quiz.startQuiz();
        });
        frame.add(spanishButton);

        frame.setVisible(true);
    }
    
    
    public static void main(String[] args) 
    {
        new VocabAppGUI();
    }
}    


