import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener{
    public static JFrame quizFrame = new JFrame("Quiz");
    public JCheckBox checkQuestion1, checkQuestion2, checkQuestion3,checkQuestion4;
    public JRadioButton radioQuestion1, radioQuestion2, radioQuestion3, radioQuestion4;
    public Quiz() {

        /* Frame Settings */
        quizFrame.setSize(500, 600);

        quizFrame.add(createCheckBox());
        quizFrame.add(createRadiobutton());
        quizFrame.add(createButton());

        quizFrame.setVisible(true);
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    /** Creates the Radiobuttons and puts them in a group so that they toggle and
     * adds them in a Jpanel and returns the panel.*/
    private JPanel createRadiobutton(){
        JPanel radioButtonPanel = new JPanel();

        JLabel radioButtonTile = new JLabel("Which number is prime?");
        radioButtonPanel.add(radioButtonTile);

        radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.PAGE_AXIS));
        radioButtonPanel.setBounds(10, 170, 300, 200);

        radioQuestion1 = new JRadioButton("21");
        radioQuestion2 = new JRadioButton("1");
        radioQuestion3 = new JRadioButton("73");
        radioQuestion4 = new JRadioButton("39");

        ButtonGroup group = new ButtonGroup(); // Allows the toggling
        group.add(radioQuestion1);
        group.add(radioQuestion2);
        group.add(radioQuestion3);
        group.add(radioQuestion4);

        radioButtonPanel.add(radioQuestion1);
        radioButtonPanel.add(radioQuestion2);
        radioButtonPanel.add(radioQuestion3);
        radioButtonPanel.add(radioQuestion4);

        return radioButtonPanel;
    }
    private JPanel createCheckBox() {
        /* Adding in checkbox section*/
        JPanel checkBoxPanel = new JPanel();
        JLabel checkBoxTitle = new JLabel("Chose all that applies: ");
        checkBoxPanel.add(checkBoxTitle);

        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
        checkBoxPanel.setBounds(10, 10, 300, 150);

        checkQuestion1 = new JCheckBox("2 + 2 = 4");
        checkQuestion2 = new JCheckBox("3 *  3 = 9");
        checkQuestion3 = new JCheckBox("7 + 3 = 11");
        checkQuestion4 = new JCheckBox("33 / 5 = 6");

        checkBoxPanel.add(checkQuestion1);
        checkBoxPanel.add(checkQuestion2);
        checkBoxPanel.add(checkQuestion3);
        checkBoxPanel.add(checkQuestion4);

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
        if(checkQuestion1.isSelected()) {
            numCorrect++;
            checkQuestion1.setBorderPainted(true);
        }
        if(checkQuestion2.isSelected()) { numCorrect++; }

        if(radioQuestion3.isSelected()) { numCorrect++; }
        JOptionPane.showMessageDialog(quizFrame,
                "Correct: " + numCorrect,
                "Output",
                JOptionPane.PLAIN_MESSAGE);
    }
}