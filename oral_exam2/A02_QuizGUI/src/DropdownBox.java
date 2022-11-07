import javax.swing.*;
import java.awt.*;

public class DropdownBox extends Components{
    public JPanel dropdownPanel = new JPanel();
    public String[] answer;

    /** The default constructor that takes the question, the options to answer
     * and the correct answers. It sends the question and correct answers to the
     * super class. */

    public DropdownBox(String title, String[] answersString, String[] correctAnswers) {
        super.title = title;
        super.correctAnswers = correctAnswers;

      // fillNewPanel(); // Creating a new JPanel with the title

        //  JLabel label = new JLabel(title);
        //
        //        label.setFont(new Font("Serif", Font.PLAIN, 22));
        //        componentPanel.add(label);
        //
        //        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        //        componentPanel.setBounds(10, y, 300, 170);

        JLabel dropdownBoxTitle = new JLabel(title);

       dropdownBoxTitle.setFont(new Font("Serif", Font.PLAIN, 22));
       componentPanel.add(dropdownBoxTitle);

        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        componentPanel.setBounds(10, Components.y, 500, 170);

       // fillPanel(answersString);

    }

    /** Creates the checkboxes of options to select and adds them into JCheckBox array and
     *  then adds them to the componentPanel in the super class. */
    private void fillPanel(String[] answersString){

        JComboBox<String> dropDownBox = new JComboBox<>(answersString);

        dropDownBox.setBounds(10, 50, 140, 50);
     componentPanel.add(dropDownBox);
    }

    public JPanel getDropdownPanel() {
        return dropdownPanel;
    }
}
