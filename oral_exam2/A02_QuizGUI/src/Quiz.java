import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener{
    public static JFrame quizFrame = new JFrame("Quiz");
    public Components checkBoxComponent;
    public Components radioBoxComponent;
    public Components dropDownComponent;

    public Quiz() {

        /* Frame Settings */
        quizFrame.setSize(500, 900);

        createCheckBox();
       // createDropDownButton();
        createRadiobutton();
        createDropDownButton();

        quizFrame.add(createButton());

        quizFrame.setVisible(true);
        //quizFrame.setFont(new Font("Serif", Font.PLAIN, 26));
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    /** Creates */
    private void createDropDownButton(){
        String[] answers = {"1","3", "1.5","9", "6", "2.75"};
        String[] correctAnswer = {"9"};

        dropDownComponent = new DropdownBox("Select the answer to the question 9-3*(1/3)+1"
                ,answers, correctAnswer);
        quizFrame.add(dropDownComponent.getComponentPanel());
    }

    /** Creates the Radiobuttons and puts them in a group so that they toggle and
     * adds them in a Jpanel and returns the panel.*/
    private void createRadiobutton(){
        String[] answers = {"21","1", "73","39", "15"};
        String[] correctAnswers = {"73"};

        radioBoxComponent = new Radiobutton("Which number is prime?",answers, correctAnswers);
        quizFrame.add(radioBoxComponent.getComponentPanel());
    }

    /** Creates */
    private void createCheckBox() {
        /* Adding in checkbox section*/

        String[] answers = {"2 + 2 = 4","3 *  3 = 9", "7 + 3 = 11","33 / 5 = 6", "6 + 7 = 12"};
        String[] correctAnswers = {"2 + 2 = 4","3 *  3 = 9", };

        checkBoxComponent= new Checkbox("Chose all that applies: ",answers, correctAnswers);
        quizFrame.add(checkBoxComponent.getComponentPanel());
    }

    private JPanel createButton() {
        /*Button section */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(60, 500, 200, 70);

     //   reset = new JButton("Reset");
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 450, 80, 30);
       // reset.setBounds(250, 450, 80, 30);

        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        return buttonPanel;
    }

    public void actionPerformed(ActionEvent e) {
        checkBoxComponent.addActionListener(this);
        radioBoxComponent.addActionListener(this);

        quizFrame.setVisible(false);
        results();
    }

    public void results(){
        JFrame resultsFrame = new JFrame("Results");
        resultsFrame.setSize(500, 900);

        resultsFrame.setVisible(true);
        resultsFrame.add(radioBoxComponent.getResultPanel());
        resultsFrame.add(checkBoxComponent.getResultPanel());
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }
}