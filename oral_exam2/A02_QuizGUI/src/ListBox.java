// ListBox.java by Fatima Kammona
// This is a subclass of Components that creates a JList.

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListBox extends Components {
    public JList answer;

    /**
     * The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class.
     */
    public ListBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel(); // Creating a new JPanel with the title
        answer = new JList(answersString);

        answer.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        componentPanel.add(answer);
    }

    /**
     * This method checks to see if any items from the JList has been selected. If it has then it checks to see if
     * the items are correct or not. If the no item has been selected then 'Unanswered' is added to the frame.
     */
    public void fillYourAnswer() {
        JPanel yourAnswerPanel = new JPanel(new GridLayout(5, 1));

        boolean selectedYes = !answer.isSelectionEmpty();
        if (selectedYes) {
            List hold = answer.getSelectedValuesList();
            for (Object o : hold) {
                yourAnswerPanel.add(new JLabel(o.toString()));
                isSelectedCorrect(o.toString());
            }
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
