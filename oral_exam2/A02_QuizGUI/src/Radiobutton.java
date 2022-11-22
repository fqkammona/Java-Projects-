// Radiobutton.java by Fatima Kammona
// This is a subclass of Components that creates radioButtons.

import javax.swing.*;
import java.awt.*;

public class Radiobutton extends Components {
    public JRadioButton[] answer;

    /**
     * The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class.
     */
    public Radiobutton(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JRadioButton[answersString.length];
        fillNewPanel();
        fillPanel(answersString);
    }

    /**
     * Creates the radio buttons of options to select and adds them into JRadioButton array and
     * adds them into a group to allow toggling and then finally adds them
     * to the componentPanel in the super class.
     */
    private void fillPanel(String[] answersString) {
        int i = 0;
        ButtonGroup group = new ButtonGroup(); // Allows for toggling

        while (i < answersString.length) {
            answer[i] = new JRadioButton(answersString[i]);
            group.add(answer[i]);
            componentPanel.add(answer[i]);
            i++;
        }
    }

    /**
     * This method finds the radioButton that is selected and adds the text into a new JPanel and then calls
     * the isSelectedCorrect method from the super class to see if the selected radioButton is correct.
     * If the no radioButton has been selected then 'Unanswered' is added to the frame.
     */
    public void fillYourAnswer() {
        int j = 0;

        JPanel yourAnswerPanel = new JPanel(new GridLayout(answer.length, 1));
        boolean isThereAnswer = false;

        while (j < answer.length) {
            String answerText = answer[j].getText();
            if (answer[j].isSelected()) {
                isThereAnswer = true;
                yourAnswerPanel.add(new JLabel(answerText));
                isSelectedCorrect(answerText);
            }
            j++;
        }

        if (isThereAnswer) {
            resultPanel.add(yourAnswerPanel);
        } else {
            JLabel label = new JLabel("Unanswered");
            resultPanel.add(label);
        }
    }

    /**
     * When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options
     */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
        fillYourAnswer();
        fillCorrectAnswers();
    }
}
