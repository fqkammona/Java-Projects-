// Checkbox class by Fatima Kammona

/** This is creates the checkbox */

import javax.swing.*;
import java.awt.*;
public class Checkbox extends Components {
    public JCheckBox[] answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */
    public Checkbox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JCheckBox[answersString.length];

        fillNewPanel(); // Creating a new JPanel with the title
        fillPanel(answersString); // Makes the checkboxes
    }

    /** Creates the checkboxes of options to select and adds them into JCheckBox array and
     *  then adds them to the componentPanel in the super class. */
    private void fillPanel(String[] answersString){
        int i = 0;

        while (i < answersString.length){
            answer[i] = new JCheckBox(answersString[i]);
            componentPanel.add(answer[i]);
            i++;
        }
    }

    /** This method finds all the selected checkboxes and adds the text into
     * a new JPanel and then goes through a while to see if the option selected is
     * a correct answer. */
    public void fillYourAnswer(){
        int j = 0;

        JPanel yourAnswerPanel = new JPanel(new GridLayout(answer.length, 1));
        boolean isThereAnswer = false; // To check if the question has been answered

        while (j < answer.length){
            String answerText = answer[j].getText();
            if(answer[j].isSelected()){
                isThereAnswer = true;
                yourAnswerPanel.add(new JLabel(answerText));
                isSelectedCorrect(answerText);
            }
            j++;
        }

        /* If an answer has been selected then add yourAnswerPanel to the
        * result panel else add label unanswered. */
        if(isThereAnswer){
            resultPanel.add(yourAnswerPanel);
        } else {
            JLabel label = new JLabel("Unanswered");
            resultPanel.add(label);
        }
    }

    /** When the button is pressed, this method calls fillResultJPanel,
     * fillYourAnswer and fillCorrectAnswer.*/
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
        fillYourAnswer();
        fillCorrectAnswers();
    }
}