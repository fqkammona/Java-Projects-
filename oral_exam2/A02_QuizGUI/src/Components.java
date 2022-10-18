import javax.swing.*;
import java.awt.*;

public abstract class Components {
    public JPanel componentPanel = new JPanel();
    public String[] correctAnswers;
    public static int y = 10;
    public String title;
    public int numOfCorrect = 0;
    public JPanel getComponentPanel(){
        return componentPanel;
    }
    public int getNumOfCorrect(){
        return numOfCorrect;
    }
    public void setNumOfCorrect(int numOfCorrect){
        this.numOfCorrect = numOfCorrect;
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
}
