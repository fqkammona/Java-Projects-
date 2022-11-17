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
        componentPanel.add(answer);
    }

    /** This method */
    public void fillYourAnswer(){
        if(answer.getSelectedItem().toString() == correctAnswers[0]){
            resultPanel.add(new JLabel(correctAnswers[0]));
        } else {
            resultPanel.add(new JLabel(answer.getSelectedItem().toString()));
        }
    }

    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();

        JLabel label = new JLabel("Your Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

        fillYourAnswer();

        fillCorrectAnswers();
    }
}
