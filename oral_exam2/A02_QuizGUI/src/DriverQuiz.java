import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverQuiz {
    static JFrame quizFrame = new JFrame("Quiz");
    public static void main(String args[])
    {
        /* Frame Settings */
        quizFrame.setSize(700,700);
        quizFrame.setLayout(new FlowLayout());


        /* Adding in checkbox section*/
        JPanel checkBoxPanel = new JPanel();
        JCheckBox newCheckBox = new JCheckBox("text");
        JCheckBox newCheckBox1 = new JCheckBox("text");
        JCheckBox newCheckBox2 = new JCheckBox("text");
        checkBoxPanel.add(newCheckBox);
        checkBoxPanel.add(newCheckBox1);
        checkBoxPanel.add(newCheckBox2);
        quizFrame.add(checkBoxPanel);


       /*Button section */
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100,250,80,30);
        quizFrame.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newCheckBox1.isSelected()){
                    JOptionPane.showMessageDialog(quizFrame,
                            "Correct",
                            "Output",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });


        quizFrame.setVisible(true);
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }

}
