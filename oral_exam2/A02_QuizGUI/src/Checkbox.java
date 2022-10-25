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
        fillResultJPane();
        int i = 0;
        while( i < answer.length){
            if(answer[i].isSelected()){
                answer[i].setForeground(Color.red);
                resultPanel.add(answer[i]);
                for (String s : correctAnswers) {
                    if (answer[i].getText().compareTo(s) == 0) {
                        answer[i].setForeground(Color.green);
                        resultPanel.add(answer[i]);
                        numOfCorrect++;
                    }
                }
            }
            i++;
        }
    }

//    public JPanel getResults() {
//        JPanel results = new JPanel();
//        results = componentPanel;
//        int i = 0;
//        while (i < answer.length) {
//            answer[i].setEnabled(false);
//            i++;
//        }
//
//        return results;
//    }
}