// ListBox class by Fatima Kammona

/** This is creates the listBox */

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListBox extends Components{
    public JList answer;
    public int size;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */
    public ListBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel(); // Creating a new JPanel with the title
        answer = new JList(answersString);
        size = answersString.length;

        answer.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        componentPanel.add(answer);
    }

    /** This method .*/
    public void fillYourAnswer() {
        JPanel yourAnswerPanel = new JPanel(new GridLayout(6, 1));

        boolean selectedYes = !answer.isSelectionEmpty();
        if (selectedYes) {
            List hold = answer.getSelectedValuesList();
            for (Object o : hold) {
                yourAnswerPanel.add(new JLabel(o.toString()));
                int i = 0;
                while(i < correctAnswers.length){ // Sees if the option selected is correct
                    if(o.toString().compareTo(correctAnswers[i]) == 0)
                        numOfCorrect++;
                    i++;
                }
            }
        } else {
            yourAnswerPanel.add(new JLabel("Unanswered"));
        }
        resultPanel.add(yourAnswerPanel);
    }

    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
        fillYourAnswer();
        fillCorrectAnswers();
    }
}
