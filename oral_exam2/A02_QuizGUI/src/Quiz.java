import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener{
    private final Container containerOfGrid;
    private JPanel buttonPanel;



    private JList listComponent;
    private Container resultContainer; // Container for results frame
    public Components checkBoxComponent;

    public Components checkBoxComponentBoxTwo;
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
       // createListComponent();

        JButton submitButton = new JButton("Submit");

        containerOfGrid.add(checkBoxComponent.getComponentPanel());
        containerOfGrid.add(radioBoxComponent.getComponentPanel());
        containerOfGrid.add(dropDownComponent.getComponentPanel());
        containerOfGrid.add(checkBoxComponentBoxTwo.getComponentPanel());
        containerOfGrid.add(submitButton);
        containerOfGrid.add(createButton(submitButton));
       // containerOfGrid.add(listComponent);
    }

    /** Creates */
    private void createCheckBox() {
        /* Adding in checkbox section*/
        String[] answers = {"2 + 2 = 4","3 *  3 = 9", "7 + 3 = 11","33 / 5 = 6", "6 + 7 = 12"};
        String[] answersForSecondBox = {"50 / 10 = 5","17 * 0 = 1", "5 > 4","6 * 36 = 36 * 6", "5 * 25 = 100"};

        String[] correctAnswers = {"2 + 2 = 4","3 *  3 = 9", };
        String[] correctAnswersForSecondBox = {"50 / 10 = 5","5 > 4", "6 * 36 = 6 *36" };

        checkBoxComponent= new Checkbox("Chose all that apply",answers, correctAnswers);
        checkBoxComponentBoxTwo = new Checkbox("Chose all that apply", answersForSecondBox, correctAnswersForSecondBox);
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

    private void createListComponent(){
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};

        listComponent = new JList(week);
    }
    private JPanel createButton(JButton buttonName) {
        buttonPanel = new JPanel(new GridLayout(2,1));
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
              radioBoxComponent.addActionListener(this);
              checkBoxComponentBoxTwo.addActionListener(this);
            results();
        }else{
            JOptionPane.showMessageDialog(this, "Read the agreement and accept it before submitting",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public JPanel fillSummaryPanel(){
        JPanel summaryPanel = new JPanel();
        int nums = Components.numOfCorrect;
        JLabel labelCorrect = new JLabel(String.valueOf(nums));

        JLabel label = new JLabel("Summary");
        Border question = BorderFactory.createTitledBorder("Summary");

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        summaryPanel.setBorder(question);
        summaryPanel.add(labelCorrect);

        return summaryPanel;
    }

    public void createResultContainer(){
        resultContainer.remove(checkBoxComponent.componentPanel);
        resultContainer.remove(radioBoxComponent.componentPanel);
        resultContainer.remove(dropDownComponent.getComponentPanel());
        resultContainer.remove(checkBoxComponentBoxTwo.getComponentPanel());
        resultContainer.remove(buttonPanel);

        resultContainer.add(fillSummaryPanel());
        resultContainer.add(checkBoxComponent.getResultPanel());
        resultContainer.add(radioBoxComponent.getResultPanel());
       // resultContainer.add(dropDownComponent.getResultPanel());
        resultContainer.add(checkBoxComponentBoxTwo.getResultPanel());
    }

    public void results(){
        JFrame resultsFrame = new JFrame("Results");
        resultsFrame.setSize(500, 900);

        resultContainer = getContentPane();
        resultContainer.setLayout(new GridLayout(6,1));

        createResultContainer();
        resultsFrame.setVisible(true);

        resultsFrame.add(resultContainer);
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }
}