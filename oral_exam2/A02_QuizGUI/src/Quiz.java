import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener{
    public static JFrame quizFrame = new JFrame("Quiz");

    public  Checkbox checkbox;
    public JCheckBox checkQuestion1, checkQuestion2, checkQuestion3,checkQuestion4;
    public JRadioButton radioQuestion1, radioQuestion2, radioQuestion3, radioQuestion4;
    public String[] dropdownOptions = {"1","3", "1.5","9", "6"};
    public Quiz() {

        /* Frame Settings */
        quizFrame.setSize(500, 900);

        createCheckBox();



        quizFrame.add(createRadiobutton());
        quizFrame.add(createDropdownBox());
        quizFrame.add(createButton());

        quizFrame.setVisible(true);
        //quizFrame.setFont(new Font("Serif", Font.PLAIN, 26));
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    private JPanel createDropdownBox(){
        JPanel dropdownBoxPanel = new JPanel();
        dropdownBoxPanel.setBounds(10, 390, 300, 200);

        JLabel dropdownQuestion = new JLabel("Select the answer to the question " +
                "\n\n9-3*(1/3)+1");

       // dropdownBoxPanel.setFont(new Font("Serif", Font.PLAIN, 14));
        dropdownBoxPanel.add(dropdownQuestion);

        JComboBox<String> dropDownBox = new JComboBox<>(dropdownOptions);
        dropDownBox.setBounds(80, 50, 140, 20);

        dropdownBoxPanel.add(dropDownBox);

        return dropdownBoxPanel;
    }
    /** Creates the Radiobuttons and puts them in a group so that they toggle and
     * adds them in a Jpanel and returns the panel.*/
    private JPanel createRadiobutton(){
        JPanel radioButtonPanel = new JPanel();
       // radioButtonPanel.setFont(new Font("Serif", Font.PLAIN, 26));

        JLabel radioButtonTile = new JLabel("Which number is prime?");
        radioButtonTile.setFont(new Font("Serif", Font.PLAIN, 22));
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

        radioQuestion1.setFont(new Font("Serif", Font.PLAIN, 18));

        radioButtonPanel.add(radioQuestion1);
        radioButtonPanel.add(radioQuestion2);
        radioButtonPanel.add(radioQuestion3);
        radioButtonPanel.add(radioQuestion4);

        radioButtonPanel.setEnabled(false);
        //radioQuestion3.setEnabled(false);
        return radioButtonPanel;
    }
    private void createCheckBox() {
        /* Adding in checkbox section*/

        String[] answers = {"2 + 2 = 4","3 *  3 = 9", "7 + 3 = 11","33 / 5 = 6", "6"};
        String[] correctAnswers = {"2 + 2 = 4","3 *  3 = 9", };

        checkbox = new Checkbox("Chose all that applies: ",answers, correctAnswers);
        quizFrame.add(checkbox.getCheckBoxPanel());
    }

    private JPanel createButton() {
        /*Button section */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(60, 500, 200, 70);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 450, 80, 30);

        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        return buttonPanel;
    }

    public void actionPerformed(ActionEvent e) {
        checkbox.addActionListener(this);

        int correct = checkbox.getCorrect();

        JOptionPane.showMessageDialog(quizFrame,
                "Correct: " + correct,
                "Output",
                JOptionPane.PLAIN_MESSAGE);
    }
}