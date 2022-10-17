/** This is creates the checkbox
 * */

import javax.swing.*;
import java.awt.*;

public class Checkbox {
    public JPanel checkBoxPanel = new JPanel();
    public JCheckBox[] answer;
    public String[] correctAnswers;
    public int numOfCorrect = 0;
    public Checkbox(String title, String[] answersString, String[] correctAnswers) {
        JLabel checkBoxTitle = new JLabel(title);

        checkBoxTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        checkBoxPanel.add(checkBoxTitle);

        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
        checkBoxPanel.setBounds(10, 10, 300, 150);

        this.correctAnswers = correctAnswers;
        answer = new JCheckBox[answersString.length];

        fillPanel(answersString);
    }

    private void fillPanel(String[] answersString){
        int i = 0;

        while (i < answersString.length){
            answer[i] = new JCheckBox(answersString[i]);
            checkBoxPanel.add(answer[i]);
            i++;
        }
    }

    public JPanel getCheckBoxPanel(){
        return checkBoxPanel;
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

    public int getNumOfCorrect(){
        return numOfCorrect;
    }
    public void setNumOfCorrect(int numOfCorrect){
         this.numOfCorrect = numOfCorrect;
    }
}