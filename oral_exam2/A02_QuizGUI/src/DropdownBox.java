import javax.swing.*;
import java.awt.*;

public class DropdownBox {
    public JPanel dropdownPanel = new JPanel();
    public String[] answer;
    public String correctAnswers;

    public DropdownBox(String title, String[] answersString, String correctAnswers) {
        JLabel dropdownBoxTitle = new JLabel(title);
        dropdownPanel.setBounds(10, 390, 300, 200);

        dropdownBoxTitle.setFont(new Font("Serif", Font.PLAIN, 16));
        dropdownPanel.add(dropdownBoxTitle);

        JComboBox<String> dropDownBox = new JComboBox<>(answersString);
        dropDownBox.setBounds(80, 50, 140, 20);

        dropdownPanel.add(dropDownBox);

        this.correctAnswers = correctAnswers;
        answer = answersString;
    }

    public JPanel getDropdownPanel() {
        return dropdownPanel;
    }
}
