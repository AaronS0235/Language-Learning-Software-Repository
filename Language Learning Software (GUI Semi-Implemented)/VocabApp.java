/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_assignment2_sem2;

/**
 *
 * @author danny
 */
import javax.swing.SwingUtilities;

public class VocabApp 
{
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        SwingUtilities.invokeLater(() -> new QuizUI(userManager));
    }
}

