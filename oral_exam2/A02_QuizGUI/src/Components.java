import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Components{
    public JPanel componentPanel = new JPanel();
    public JPanel resultPanel = new JPanel();
    public String[] correctAnswers;
    public static int y = 10, yy= 150, numOfCorrect = 0;
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
        JLabel label = new JLabel(title);
        Border question = BorderFactory.createTitledBorder(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        componentPanel.setBorder(question);

        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        componentPanel.setBounds(10, y, 300, 170);

        y += 170;
    }

    /** Adds all the correct answers to the results JPanel. */
    public void fillCorrectAnswers(){
        for(String cAnswers: correctAnswers)
            resultPanel.add(new JLabel(cAnswers));
    }

    /** Creates a new JPanel for the results of the prompt */
    public void fillResultJPane(){
        JLabel label = new JLabel("Prompt- " + title +"\n");

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        resultPanel.add(label);

        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        resultPanel.setBounds(10, yy, 400, 170);

        y += 170;
    }

    public void addActionListener(Quiz quiz) { }
}
