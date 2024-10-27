/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author danny
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizUI extends JFrame {
    private UserManager userManager;
    private JComboBox<String> languageSelector;
    private JTextArea quizArea;
    private JButton startQuizButton;

    public QuizUI(UserManager userManager) {
        this.userManager = userManager;
        setTitle("Language Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        languageSelector = new JComboBox<>(new String[]{"Hindi", "Spanish", "Korean"});
        quizArea = new JTextArea(10, 30);
        quizArea.setEditable(false);

        startQuizButton = new JButton("Start Quiz");
        startQuizButton.addActionListener(new StartQuizListener());

        setLayout(new BorderLayout());
        add(languageSelector, BorderLayout.NORTH);
        add(new JScrollPane(quizArea), BorderLayout.CENTER);
        add(startQuizButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class StartQuizListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedLanguage = (String) languageSelector.getSelectedItem();
            Quiz quiz = createQuiz(selectedLanguage);
            quizArea.setText(quiz.showQuiz());
        }
    }

    private Quiz createQuiz(String language) {
        switch (language) {
            case "Hindi":
                return new HindiQuiz(userManager.getLessons("Hindi"));
            case "Spanish":
                return new SpanishQuiz(userManager.getLessons("Spanish"));
            case "Korean":
                return new KoreanQuiz(userManager.getLessons("Korean"));
            default:
                throw new IllegalArgumentException("Invalid language selected");
        }
    }
}
