/** This is creates the checkbox
 * */

import javax.swing.*;
import java.awt.*;
public class Checkbox extends Components {
    public JCheckBox[] answer;
    public Checkbox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JCheckBox[answersString.length];

        fillNewPanel();
        fillPanel(answersString);
    }

    private void fillPanel(String[] answersString){
        int i = 0;

        while (i < answersString.length){
            answer[i] = new JCheckBox(answersString[i]);
            componentPanel.add(answer[i]);
            i++;
        }
    }

    public void addActionListener(Quiz quiz) {
        int i = 0;
        while( i < answer.length){
            if(answer[i].isSelected()){
                for (String s : correctAnswers) {
                    if (answer[i].getText().compareTo(s) == 0) {
                        numOfCorrect++;
                    }
                }
            }
            i++;
        }
    }
}