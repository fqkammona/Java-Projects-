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

    private JPanel getCheckboxPanel(int row, int col){
        JPanel checkboxPanel = new JPanel(new GridLayout(row, col));


        return checkboxPanel;
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
     * a new Jlabel and then goes through a while to see if the option selected is
     * a correct answer.*/
    public void fillYourAnswer(){
        int j = 0;

        while (j < answer.length){
            String answerText = answer[j].getText();
            if(answer[j].isSelected()){
                resultPanel.add(new JLabel(answerText));
                int i = 0;
                while(i < correctAnswers.length){ // Sees if the option selected is correct
                    if(answerText.compareTo(correctAnswers[i]) == 0)
                        numOfCorrect++;
                    i++;
                }
            }
            j++;
        }
    }

    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        //fillResultJPane();

        JLabel label = new JLabel("Your Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

       // fillYourAnswer();

        label = new JLabel("Correct Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

       // fillCorrectAnswers();
    }

}