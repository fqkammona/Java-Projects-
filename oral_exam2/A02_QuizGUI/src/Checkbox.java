//Checkbox.java by Fatima Kammona
// This is a subclass of Components that creates checkBoxes.

import javax.swing.*;
import java.awt.*;

public class Checkbox extends Components {
    public JCheckBox[] answer;

    /**
     * The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class.
     */
    public Checkbox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JCheckBox[answersString.length];

        fillNewPanel(); // Creating a new JPanel with the title
        fillPanel(answersString); // Makes the checkboxes
    }

    /**
     * Creates the checkboxes of options to select and adds them into JCheckBox array and
     * then adds them to the componentPanel in the super class.
     */
    private void fillPanel(String[] answersString) {
        int i = 0;

        while (i < answersString.length) {
            answer[i] = new JCheckBox(answersString[i]);
            componentPanel.add(answer[i]);
            i++;
        }
    }

    /**
     * This method finds all the selected checkboxes and adds the text into a new JPanel and then calls the
     * isSelectedCorrect method from the super class in the super class to see if the selected checkBox is correct.
     * If the no checkbox has been selected then 'Unanswered' is added to the frame.
     */
    public void fillYourAnswer() {
        int i = 0;

        JPanel yourAnswerPanel = new JPanel(new GridLayout(answer.length, 1));
        boolean isThereAnswer = false; // To check if the question has been answered

        while (i < answer.length) {
            String answerText = answer[i].getText();
            if (answer[i].isSelected()) {
                isThereAnswer = true;
                yourAnswerPanel.add(new JLabel(answerText));
                isSelectedCorrect(answerText);
            }
            i++;
        }

        /* If an answer has been selected then add yourAnswerPanel to the
         * result panel else add label unanswered. */
        if (isThereAnswer) {
            resultPanel.add(yourAnswerPanel);
        } else {
            JLabel label = new JLabel("Unanswered");
            resultPanel.add(label);
        }
    }

    /**
     * When the button is pressed, this method calls fillResultJPanel,
     * fillYourAnswer and fillCorrectAnswer.
     */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
        fillYourAnswer();
        fillCorrectAnswers();
    }
}