import javax.swing.*;
import java.awt.*;

public class DropdownBox extends Components{
    public JComboBox answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */
    public DropdownBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel();

        answer = new JComboBox(answersString);
        answer.setSelectedIndex(-1);
        componentPanel.add(answer);
    }

    /** This method */
    public void fillYourAnswer(){
        JPanel yourAnswerPanel = new JPanel(new GridLayout(1, 1));

        int isSelected = answer.getSelectedIndex();
        if (isSelected != -1) {
            if(answer.getSelectedItem().toString() == correctAnswers[0]){
                yourAnswerPanel.add(new JLabel(correctAnswers[0]));
                numOfCorrect++;
            } else {
                yourAnswerPanel.add(new JLabel(answer.getSelectedItem().toString()));
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
