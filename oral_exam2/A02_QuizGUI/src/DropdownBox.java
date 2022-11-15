import javax.swing.*;
import java.awt.*;

public class DropdownBox extends Components{
    public String[] answer;
    //public JCheckBox[] answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */

    public DropdownBox(String title, String[] answersString, String[] correctAnswers) {
//        super.title = title;
//        super.correctAnswers = correctAnswers;
//
//        JLabel dropdownBoxTitle = new JLabel(title);
//        componentPanel.add(dropdownBoxTitle);
//        dropdownBoxTitle.setFont(new Font("Serif", Font.PLAIN, 22));
//
//        componentPanel.setBounds(10, Components.y, 500, 70);
//
//        Components.y += 100;
//
//        fillPanel(answersString);

//        answer = new JCheckBox[answersString.length];

        super.title = title;
        super.correctAnswers = correctAnswers;

        fillNewPanel();
      //  fillPanel(answersString);

    }

    /** Creates the checkboxes of options to select and adds them into JCheckBox array and
     *  then adds them to the componentPanel in the super class. */
    private void fillPanel(String[] answersString){

        JComboBox<String> dropDownBox = new JComboBox<>(answersString);
      //  componentPanel.add(dropDownBox);

      //  dropDownBox.setBounds(0, 510, 40, 50);
//        int i = 0;
//        while (i < answersString.length){
//            answer[i] = new JCheckBox(answersString[i]);
//         //   answer[i] = answersString[i];
//            componentPanel.add(answer[i]);
//            i++;
//        }
       // componentPanel.add(answersString[0]);
    }

    /** This method finds all the selected checkboxes and adds the text into
     * a new Jlabel and then goes through a while to see if the option selected is
     * a correct answer.*/
//    public void fillYourAnswer(){
//        resultPanel.add(new JLabel(answer[0]));
//    }

    /** When the button is pressed, this method creates the results panel
     * and adds the options selected and adds the correct options */
    public void addActionListener(Quiz quiz) {
        fillResultJPane();

        JLabel label = new JLabel("Your Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

     //   fillYourAnswer();

        label = new JLabel("Correct Answer(s)");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        resultPanel.add(label);

        fillCorrectAnswers();
    }

}
