import javax.swing.*;
public class Checkbox {
    public Checkbox(JFrame quizFrame){
        JCheckBox checkBox1 = new JCheckBox("2 + 2  = 4");
        checkBox1.setBounds(100,200, 50,50);
        quizFrame.add(checkBox1);
    }

}
