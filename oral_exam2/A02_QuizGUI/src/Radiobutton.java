// Radiobutton class by Fatima Kammona

/** Creates the Radiobuttons and puts them in a group so that they toggle and
 * adds them in a Jpanel and returns the panel.*/
import javax.swing.*;
import java.awt.*;
public class Radiobutton extends Components{
    public JRadioButton[] answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */
    public Radiobutton(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        answer = new JRadioButton[answersString.length];
        fillNewPanel();
        fillPanel(answersString);
    }

    /** Creates the radio buttons of options to select and adds them into JRadioButton array and
     * adds them into a group to allow toggling and then finally adds them
     * to the componentPanel in the super class. */
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

    /** This method finds all the selected checkboxes and adds the text into
     * a new Jlabel and then goes through a while to see if the option selected is
     * a correct answer.*/
    public void fillYourAnswer(){
        int j = 0;

        JPanel yourAnswerPanel = new JPanel(new GridLayout(answer.length, 1));
        boolean isThereAnswer = false;

        while (j < answer.length){
            String answerText = answer[j].getText();
            if(answer[j].isSelected()){
                isThereAnswer = true;
                yourAnswerPanel.add(new JLabel(answerText));
                if(answerText.compareTo(correctAnswers[0]) == 0)
                        numOfCorrect++;
            }
            j++;
        }

        if(isThereAnswer == true){
            resultPanel.add(yourAnswerPanel);
        } else {
            JLabel label = new JLabel("Unanswered");
            resultPanel.add(label);
        }
    }
    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();
        fillYourAnswer();
        fillCorrectAnswers();
    }
}
