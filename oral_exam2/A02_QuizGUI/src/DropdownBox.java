import javax.swing.*;
import java.awt.*;

public class DropdownBox extends Components{
    public String[] answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */

    public DropdownBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

        JLabel dropdownBoxTitle = new JLabel(title);
        componentPanel.add(dropdownBoxTitle);
        dropdownBoxTitle.setFont(new Font("Serif", Font.PLAIN, 22));


        //componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        componentPanel.setBounds(10, Components.y, 500, 70);

        Components.y += 100;

        fillPanel(answersString);

    }

    /** Creates the checkboxes of options to select and adds them into JCheckBox array and
     *  then adds them to the componentPanel in the super class. */
    private void fillPanel(String[] answersString){

        JComboBox<String> dropDownBox = new JComboBox<>(answersString);

        dropDownBox.setBounds(0, 510, 40, 50);
        //dropdownPanel.add(dropDownBox);

        componentPanel.add(dropDownBox);
    }

}
