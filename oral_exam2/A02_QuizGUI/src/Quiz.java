import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener{
    public static JFrame quizFrame = new JFrame("Quiz");
    public JCheckBox checkQuestion1, checkQuestion2, checkQuestion3;

    public Quiz() {

        /* Frame Settings */
        quizFrame.setSize(700, 700);

        quizFrame.add(createCheckBox());
        quizFrame.add(createButton());

        quizFrame.setVisible(true);
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    private JPanel createCheckBox() {
        /* Adding in checkbox section*/
        JPanel checkBoxPanel = new JPanel();
        JLabel checkBoxTitle = new JLabel("Chose all that applies: ");
        checkBoxPanel.add(checkBoxTitle);

        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
        checkBoxPanel.setBounds(0, 10, 300, 200);

        checkQuestion1 = new JCheckBox("2 + 2 = 4");
        checkQuestion2 = new JCheckBox("3 *  3 = 9");
        checkQuestion3 = new JCheckBox("7 + 3 = 11");

        checkQuestion1.setBounds(100, 100, 150, 50);
        checkQuestion2.setBounds(100, 100, 150, 50);
        checkQuestion3.setBounds(100, 100, 150, 50);

        checkBoxPanel.add(checkQuestion1);
        checkBoxPanel.add(checkQuestion2);
        checkBoxPanel.add(checkQuestion3);

        return checkBoxPanel;
    }

    private JPanel createButton() {
        /*Button section */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(60, 600, 200, 70);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 550, 80, 30);

        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        return buttonPanel;
    }

    public void actionPerformed(ActionEvent e) {
        int numCorrect = 0;
        if(checkQuestion1.isSelected()) { numCorrect++; }
        if(checkQuestion2.isSelected()) { numCorrect++; }

        JOptionPane.showMessageDialog(quizFrame,
                "Correct: " + numCorrect,
                "Output",
                JOptionPane.PLAIN_MESSAGE);
    }
}