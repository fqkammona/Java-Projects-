/** This is creates the checkbox
 * */

import javax.swing.*;
public class Checkbox {
    public JPanel checkBoxPanel = new JPanel();
    public JCheckBox[] answer;
    public String[] correctAnswers;
    public int correct = 0;
    public Checkbox(String title, String[] answersString, String[] correctAnswers) {
        JLabel checkBoxTitle = new JLabel(title);

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
                        correct++;
                    }
                }
            }
            i++;
        }
    }

    public int getCorrect(){
        return correct;
    }
    public void setCorrect(int correct){
         this.correct = correct;
    }
}