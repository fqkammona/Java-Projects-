// ListBox class by Fatima Kammona

/** This is creates the listBox */

import javax.swing.*;
import java.awt.*;

public class ListBox extends Components{
    public JList answer;
    public JList secondAnswer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */
    public ListBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel(); // Creating a new JPanel with the title
        answer = new JList<>(answersString);
        secondAnswer = new JList<>();

        answer.setSelectionInterval(0, answersString.length);
         componentPanel.add(answer);
        //componentPanel.add(secondAnswer);
    }

    /** This method finds all the selected checkboxes and adds the text into
     * a new Jlabel and then goes through a while to see if the option selected is
     * a correct answer.*/
    public void fillYourAnswer(){
        int i = 0;

//        while(i < correctAnswers.length){
//            if(answer.{
//                resultPanel.add(new JLabel(correctAnswers[0]));
//            } else {
//                resultPanel.add(new JLabel(answer.getSelectedItem().toString()));
//            }
//        }

    }

    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
      //  fillYourAnswer();
        fillCorrectAnswers();
    }
}
