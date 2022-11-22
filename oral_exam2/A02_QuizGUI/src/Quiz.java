// Quiz.java by Fatima Kammona

/* This class creates a quiz using different types of components using the abstract Components
 * class and then adds them into the frame. After the agreement checkbox is clicked and the button
 * is pressed a new frame with the results will appear.  */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    private final Container containerOfGrid; // Container for the main frame
    private JPanel buttonPanel; // The panel that holds agreementBox and submit button
    private Container resultContainer; // Container for results frame
    public JCheckBox agreementBox = new JCheckBox("I agree that I didn't cheat");

    /* These are the instance variables for the different components in quiz */
    public Components checkBoxComponent;
    private Components listComponent;
    public Components checkBoxComponentBoxTwo;
    public Components radioBoxComponent;
    public Components dropDownComponent;

    /**
     * The default construction that sets the frame size, title, and close on exit. It also
     * initializes containerOfGrid and calls createAllComponents.
     */
    public Quiz() {
        super("Quiz");

        containerOfGrid = getContentPane();
        containerOfGrid.setLayout(new GridLayout(6, 1));

        setSize(500, 900); // set window size
        setVisible(true); // show window

        createAllComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

    /**
     * Calls all the functions need to initialize instance components and then
     * adds them into the containerOfGrid so that they are displayed on the main frame.
     */
    private void createAllComponents() {
        createCheckBox();
        createRadiobutton();
        createDropDownButton();
        createListComponent();

        JButton submitButton = new JButton("Submit");

        containerOfGrid.add(checkBoxComponent.getComponentPanel());
        containerOfGrid.add(radioBoxComponent.getComponentPanel());
        containerOfGrid.add(dropDownComponent.getComponentPanel());
        containerOfGrid.add(checkBoxComponentBoxTwo.getComponentPanel());
        containerOfGrid.add(listComponent.getComponentPanel());
        containerOfGrid.add(submitButton);
        containerOfGrid.add(createButton(submitButton));
    }

    /**
     * Initializes the checkBoxComponent and checkboxComponentBoxTwo by calling the Checkbox class.
     */
    private void createCheckBox() {
        String[] answers = {"2 + 2 = 4", "3 *  3 = 9", "7 + 3 = 11", "33 / 5 = 6", "6 + 7 = 12"};
        String[] answersForSecondBox = {"50 / 10 = 5", "17 * 0 = 1", "5 > 4", "6 * 6 = 36", "5 * 25 = 100"};

        String[] correctAnswers = {"2 + 2 = 4", "3 *  3 = 9",};
        String[] correctAnswersForSecondBox = {"50 / 10 = 5", "5 > 4", "6 * 6 = 36"};

        checkBoxComponent = new Checkbox("Chose all that apply", answers, correctAnswers);
        checkBoxComponentBoxTwo = new Checkbox("Chose all that apply", answersForSecondBox, correctAnswersForSecondBox);
    }

    /**
     * Initializes the radioBoxComponent by calling the Radiobutton class.
     */
    private void createRadiobutton() {
        String[] answers = {"21", "1", "73", "39", "15"};
        String[] correctAnswers = {"73"};

        radioBoxComponent = new Radiobutton("Which number is prime?", answers, correctAnswers);
    }

    /**
     * Initializes the dropDownComponent by calling the DropdownBox class.
     */
    private void createDropDownButton() {
        String[] answers = {"1", "3", "1.5", "9", "6", "2.75"};
        String[] correctAnswer = {"9"};

        dropDownComponent = new DropdownBox("Select the correct output: 9-3*(1/3)+1"
                , answers, correctAnswer);
    }

    /**
     * Initializes the listComponent by calling the ListBox class.
     */
    private void createListComponent() {
        String[] typeOfMethod = {"Multiplication", "Division", "Subtraction",
                "Addition", "Integration"};
        String[] correctAnswer = {"Multiplication", "Addition", "Division"};

        listComponent = new ListBox("Chose all that apply: 2 + 1 * 8 / 4 = 4", typeOfMethod, correctAnswer);
    }

    /**
     * Initializes the buttonPanel and adds the submit button and agreementBox to the
     * panel and then returns the panel.
     */
    private JPanel createButton(JButton buttonName) {
        buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Details"));
        buttonPanel.add(agreementBox);
        buttonName.setBounds(25, 25, 25, 25);
        buttonPanel.add(buttonName);

        buttonName.addActionListener(this);

        return buttonPanel;
    }

    /**
     * When the button is clicked, the program will first check if the agreement checkbox
     * has been selected if so then all the components actionListener will be added and the
     * results function will be called. If the box has not been selected a warning will be
     * displayed.
     */
    public void actionPerformed(ActionEvent e) {
        if (agreementBox.isSelected()) {
            checkBoxComponent.addActionListener(this);
            dropDownComponent.addActionListener(this);
            radioBoxComponent.addActionListener(this);
            checkBoxComponentBoxTwo.addActionListener(this);
            listComponent.addActionListener(this);
            results();
        } else {
            JOptionPane.showMessageDialog(this, "Read the agreement and accept it before submitting",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This accessor method returns the JPanel that has the results of the quiz.
     */
    public JPanel fillSummaryPanel() {
        JPanel summaryPanel = new JPanel();
        int nums = Components.numOfCorrect;
        int totalCorrect = Components.totalNumCorrect;

        String out = nums + "/" + totalCorrect;
        JLabel label = new JLabel("Summary");
        Border question = BorderFactory.createTitledBorder("Summary");

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        summaryPanel.setBorder(question);
        summaryPanel.add(new JLabel(out));

        return summaryPanel;
    }

    /**
     * This method removes all the main componentPanel of each of the quiz components
     * and removes the buttonPanel and then adds the resultPanel for each of the components
     * and adds the fillSummaryPanel.
     */
    public void createResultContainer() {
        resultContainer.remove(checkBoxComponent.getComponentPanel());
        resultContainer.remove(radioBoxComponent.getComponentPanel());
        resultContainer.remove(dropDownComponent.getComponentPanel());
        resultContainer.remove(checkBoxComponentBoxTwo.getComponentPanel());
        resultContainer.remove(listComponent.getComponentPanel());
        resultContainer.remove(buttonPanel);

        resultContainer.add(checkBoxComponent.getResultPanel());
        resultContainer.add(radioBoxComponent.getResultPanel());
        resultContainer.add(dropDownComponent.getResultPanel());
        resultContainer.add(checkBoxComponentBoxTwo.getResultPanel());
        resultContainer.add(listComponent.getResultPanel());
        resultContainer.add(fillSummaryPanel());
    }

    /**
     * This method sets the result frame size, title, and close on exit. It also
     * initializes resultContainer and calls createResultContainer.
     */
    public void results() {
        JFrame resultsFrame = new JFrame("Results");
        resultsFrame.setSize(500, 900);

        resultContainer = getContentPane();
        resultContainer.setLayout(new GridLayout(6, 1));

        createResultContainer();
        resultsFrame.setVisible(true);

        resultsFrame.add(resultContainer);
        resultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }
}