/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author damnd
 */
public class KoreanQuiz extends QuizTemplate 
{
    private List<VocabItem> vocabList;
    private JFrame frame;
    private JTextField answerField;
    private JLabel questionLabel;
    private int currentQuestionIndex;

    public KoreanQuiz(List<VocabItem> vocabList) 
    {
        this.vocabList = vocabList;
        currentQuestionIndex = 0;
        setupGUI();
    }

    private void setupGUI() 
    {
        frame = new JFrame("Korean Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 30, 300, 30);
        frame.add(questionLabel);

        answerField = new JTextField();
        answerField.setBounds(50, 70, 200, 30);
        frame.add(answerField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 70, 100, 30);
        submitButton.addActionListener(e -> checkAnswer());
        frame.add(submitButton);

        frame.setVisible(true);
    }

    @Override
    public void startQuiz() 
    {
        loadNextQuestion();
    }

    private void loadNextQuestion() 
    {
        if (currentQuestionIndex < vocabList.size()) 
        {
            VocabItem item = vocabList.get(currentQuestionIndex);
            questionLabel.setText("Translate to English: " + item.getForeignWord());
            answerField.setText("");
        } 
        else 
        {
            showScore();
            frame.dispose();
        }
    }

    private void checkAnswer() 
    {
        String answer = answerField.getText().trim();
        VocabItem item = vocabList.get(currentQuestionIndex);

        if (answer.equalsIgnoreCase(item.getEnglishTranslation())) 
        {
            score++;
            JOptionPane.showMessageDialog(frame, "Correct!");
        } 
        else 
        {
            JOptionPane.showMessageDialog(frame, "Wrong! Correct answer: " + item.getEnglishTranslation());
        }
        currentQuestionIndex++;
        loadNextQuestion();
    }
}


