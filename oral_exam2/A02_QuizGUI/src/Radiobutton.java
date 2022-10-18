/** Creates the Radiobuttons and puts them in a group so that they toggle and
 * adds them in a Jpanel and returns the panel.*/
import javax.swing.*;
import java.awt.*;
public class Radiobutton {
    public JPanel radioButtonPanel = new JPanel();
    public JRadioButton[] answer;
    public String correctAnswers;
    public int numOfCorrect = 0;
    public Radiobutton(String title, String[] answersString, String correctAnswers) {
        JLabel radioButtonTitle = new JLabel(title);

        radioButtonTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        radioButtonPanel.add(radioButtonTitle);

        radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.PAGE_AXIS));
        radioButtonPanel.setBounds(10, 170, 300, 200);

        this.correctAnswers = correctAnswers;
        answer = new JRadioButton[answersString.length];

        fillPanel(answersString);
    }

    private void fillPanel(String[] answersString){
        int i = 0;
        ButtonGroup group = new ButtonGroup(); // Allows the toggling

        while (i < answersString.length){
            answer[i] = new JRadioButton(answersString[i]);
            group.add(answer[i]);
            radioButtonPanel.add(answer[i]);
            i++;
        }
    }

    public void addActionListener(Quiz quiz) {
        int i = 0;

        while(i < answer.length){
           // answer[i].setEnabled(false);
            if(answer[i].getText().compareTo(correctAnswers) == 0){
                answer[i].setForeground(Color.green);
                numOfCorrect++;
            } else if(answer[i].isSelected() && answer[i].getText().compareTo(correctAnswers) != 0){
                answer[i].setForeground(Color.red);
            }
         //   answer[i].setEnabled(false);
            i++;
        }
    }

    public int getNumOfCorrect(){
        return numOfCorrect;
    }
    public JPanel getRadioButtonPanel(){
        return radioButtonPanel;
    }
}
