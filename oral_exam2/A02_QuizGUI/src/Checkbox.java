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

    public void fillYourAnswer(){
        int j = 0;

        while (j < answer.length){
            answer[j].setEnabled(false);
            if(answer[j].isSelected()){
                resultPanel.add(answer[j]);
            }
            j++;
        }
    }

    public void fillCorrectAnswers(){
        int i = 0;
        while( i < answer.length){
            for (String s : correctAnswers){
                if (answer[i].getText().compareTo(s) == 0) {
                    resultPanel.add(answer[i]);
                }
            }
            i++;
        }
    }
    public void addActionListener(Quiz quiz) {
        fillResultJPane();

        JLabel label = new JLabel("Your Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

        fillYourAnswer();

        label = new JLabel("Correct Answer(s)");
        resultPanel.add(label);

        fillCorrectAnswers();
    }

}