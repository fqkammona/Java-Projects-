// Components.java by Fatima Kammona
/* This is the super class that has subclasses that create different types of components.
 * This class also keeps track of the numbers correct and the total correct numbers.  */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Components {
    public JPanel componentPanel;
    public JPanel resultPanel;
    public String[] correctAnswers;
    public static int numOfCorrect = 0;
    public static int totalNumCorrect = 0;
    public String title;

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public JPanel getComponentPanel() {
        return componentPanel;
    }

    /**
     * Creates a new JPanel for the prompt and options to select.
     */
    public void fillNewPanel() {
        componentPanel = new JPanel();

        JLabel label = new JLabel(title);
        Border question = BorderFactory.createTitledBorder(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        componentPanel.setBorder(question);
    }

    /**
     * Creates a new JPanel for the results of the prompt
     */
    public void fillResultJPane() {
        resultPanel = new JPanel(new GridLayout(2, 2));

        JLabel label = new JLabel("Question: " + title);
        Border question = BorderFactory.createTitledBorder(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        resultPanel.setBorder(question);

        label = new JLabel("Your Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

        label = new JLabel("\nCorrect Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);
    }

    /**
     * Checks if the selected option is correct
     */
    public void isSelectedCorrect(String answerText) {
        int i = 0;
        while (i < correctAnswers.length) {
            if (answerText.compareTo(correctAnswers[i]) == 0)
                numOfCorrect++;
            i++;
        }
    }

    /**
     * Adds all the correct answers to the results JPanel.
     */
    public void fillCorrectAnswers() {
        JPanel correctAnswerPanel = new JPanel(new GridLayout(correctAnswers.length + 1, 1));

        for (String cAnswers : correctAnswers)
            correctAnswerPanel.add(new JLabel(cAnswers));

        totalNumCorrect += correctAnswers.length;
        resultPanel.add(correctAnswerPanel);
    }

    public void addActionListener(Quiz quiz) {
    }
}
