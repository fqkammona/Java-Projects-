import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Components{
    public JPanel componentPanel;
    public JPanel resultPanel;
    public String[] correctAnswers;
    public static int numOfCorrect = 0;
    public String title;

    public JPanel getResultPanel(){ return resultPanel; }
    public JPanel getComponentPanel(){
        return componentPanel;
    }
    public int getNumOfCorrect(){
        return numOfCorrect;
    }
    public void setNumOfCorrect(int numOfCorrect){
        Components.numOfCorrect = numOfCorrect;
    }

    /** Creates a new JPanel for the prompt and options to select. */
    public void fillNewPanel(){
        componentPanel = new JPanel();

        JLabel label = new JLabel(title);
        Border question = BorderFactory.createTitledBorder(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        componentPanel.setBorder(question);
    }

    /** Creates a new JPanel for the results of the prompt */
    public void fillResultJPane(){
        resultPanel = new JPanel();

        JLabel label = new JLabel("Question: " + title);
        Border question = BorderFactory.createTitledBorder(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        resultPanel.setBorder(question);
    }


    /** Adds all the correct answers to the results JPanel. */
    public void fillCorrectAnswers(){
        for(String cAnswers: correctAnswers)
            resultPanel.add(new JLabel(cAnswers));
    }

    public void addActionListener(Quiz quiz) { }
}
