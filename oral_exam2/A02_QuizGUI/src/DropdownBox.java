// DropdownBox.java by Fatima Kammona
//This is a subclass of Components that creates a JComboBox.

import javax.swing.*;
import java.awt.*;

public class DropdownBox extends Components {
    public JComboBox answer;

    /**
     * The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class.
     */
    public DropdownBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel();

        answer = new JComboBox(answersString);
        answer.setSelectedIndex(-1);
        componentPanel.add(answer);
    }

    /**
     * This method checks to see if an item from the dropDown box has been selected. If it has then it checks
     * to see if the item is correct or not. If the no item has been selected then 'Unanswered' is added to the frame.
     */
    public void fillYourAnswer() {
        JPanel yourAnswerPanel = new JPanel(new GridLayout(0, 1));

        int isSelected = answer.getSelectedIndex();
        if (isSelected != -1) {
            yourAnswerPanel.add(new JLabel(answer.getSelectedItem().toString()));
            isSelectedCorrect(answer.getSelectedItem().toString());
        } else {
            yourAnswerPanel.add(new JLabel("Unanswered"));
        }
        resultPanel.add(yourAnswerPanel);
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
