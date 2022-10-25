import javax.swing.*;
import java.awt.*;

public abstract class Components {
    public JPanel componentPanel = new JPanel();
    public String[] correctAnswers;
    public static int y = 10;
    public String title;
    public static int numOfCorrect = 0;
    public JPanel resultPanel = new JPanel();

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

    public void fillNewPanel(){
        JLabel label = new JLabel(title);

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        componentPanel.add(label);

        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        componentPanel.setBounds(10, y, 300, 170);
        y += 170;
    }

    public void  addActionListener(Quiz quiz) {
    }

    public void fillResultJPane(){
        JLabel label = new JLabel("Answer");

        label.setFont(new Font("Serif", Font.PLAIN, 22));
        componentPanel.add(label);

        componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.PAGE_AXIS));
        componentPanel.setBounds(10, y, 300, 170);
        y += 170;
    }


}
