/** Creates the Radiobuttons and puts them in a group so that they toggle and
 * adds them in a Jpanel and returns the panel.*/
import javax.swing.*;
import java.awt.*;
public class Radiobutton extends Components{
    public JRadioButton[] answer;

    public Radiobutton(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JRadioButton[answersString.length];

        fillNewPanel();
        fillPanel(answersString);

    }

    private void fillPanel(String[] answersString){
        int i = 0;
        ButtonGroup group = new ButtonGroup(); // Allows the toggling

        while (i < answersString.length){
            answer[i] = new JRadioButton(answersString[i]);
            group.add(answer[i]);
            componentPanel.add(answer[i]);
            i++;
        }
    }

    public void addActionListener(Quiz quiz) {
        //int i = 0;

//        while(i < answer.length){
//           // answer[i].setEnabled(false);
//            if(answer[i].getText().compareTo(correctAnswers) == 0){
//                answer[i].setForeground(Color.green);
//                numOfCorrect++;
//            } else if(answer[i].isSelected() && answer[i].getText().compareTo(correctAnswers) != 0){
//                answer[i].setForeground(Color.red);
//            }
//         //   answer[i].setEnabled(false);
//            i++;
//        }

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
