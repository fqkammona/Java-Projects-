import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener{
    private final Container containerOfGrid;
    public Components checkBoxComponent;
    public Components radioBoxComponent;
    public JCheckBox agreementBox = new JCheckBox("I agree that I didn't cheat");
    public Components dropDownComponent;

    public Quiz(){
        super("Quiz");

        containerOfGrid = getContentPane();
        containerOfGrid.setLayout(new GridLayout(6,1));

        setSize(500, 500); // set window size
        setVisible(true); // show window

        createAllComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    private void createAllComponents(){
        createCheckBox();
        createRadiobutton();
      createDropDownButton();

        JButton submitButton = new JButton("Submit");

        containerOfGrid.add(checkBoxComponent.getComponentPanel());
        containerOfGrid.add(radioBoxComponent.getComponentPanel());
        containerOfGrid.add(dropDownComponent.getComponentPanel());
        containerOfGrid.add(submitButton);
        containerOfGrid.add(createButton(submitButton));
    }

    /** Creates */
    private void createCheckBox() {
        /* Adding in checkbox section*/

        String[] answers = {"2 + 2 = 4","3 *  3 = 9", "7 + 3 = 11","33 / 5 = 6", "6 + 7 = 12"};
        String[] correctAnswers = {"2 + 2 = 4","3 *  3 = 9", };
        checkBoxComponent= new Checkbox("Chose all that applies: ",answers, correctAnswers);
    }
    /** Creates the Radiobuttons and puts them in a group so that they toggle and
     * adds them in a Jpanel and returns the panel.*/
    private void createRadiobutton() {
        String[] answers = {"21", "1", "73", "39", "15"};
        String[] correctAnswers = {"73"};

        radioBoxComponent = new Radiobutton("Which number is prime?", answers, correctAnswers);
    }

    /** Creates */
    private void createDropDownButton(){
        String[] answers = {"1","3", "1.5","9", "6", "2.75"};
        String[] correctAnswer = {"9"};

        dropDownComponent = new DropdownBox("Select the correct output: 9-3*(1/3)+1"
                ,answers, correctAnswer);
    }
    private JPanel createButton(JButton buttonName) {
        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Details"));
        buttonPanel.add(agreementBox);
        buttonName.setBounds(25,25, 25,25);
        buttonPanel.add(buttonName);

        buttonName.addActionListener(this);

        return buttonPanel;
    }

    public void actionPerformed(ActionEvent e) {

        if(agreementBox.isSelected()){
            checkBoxComponent.addActionListener(this);
            // dropDownComponent.addActionListener(this);
            //  radioBoxComponent.addActionListener(this);
            results();
        }else{
            JOptionPane.showMessageDialog(this, "Read the agreement and accept it before submitting",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void results(){
        JFrame resultsFrame = new JFrame("Results");
        resultsFrame.setSize(500, 900);

        resultsFrame.setVisible(true);
     //   resultsFrame.add(dropDownComponent.getResultPanel());
     //   resultsFrame.add(radioBoxComponent.getResultPanel());
        resultsFrame.add(checkBoxComponent.getResultPanel());
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }
}