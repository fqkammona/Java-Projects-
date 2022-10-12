import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Checkbox {
    public JPanel checkBoxPanel = new JPanel();
//    Checkbox cc1 = new Checkbox("4");
//    Checkbox cc2 = new Checkbox("6");
    static int x = 100;
    static int y = 200;
//    public Checkbox(JFrame quizFrame){
//        JCheckBox checkBox1 = new JCheckBox("2 + 2  = 4");
//        checkBox1.setBounds(100,200, 50,50);
//        quizFrame.add(checkBox1);
//    }

//    public Checkbox(){
//        JCheckBox checkBox1 = new JCheckBox("2 + 2 = 4");
//        checkBox1.setBounds(100,200, 50,50);
//        checkBoxPanel.add(checkBox1);
//    }

    public Checkbox(String text) {
        JCheckBox newCheckBox = new JCheckBox(text);
        newCheckBox.setBounds(x, y, 50, 50);
        y += 70;
        checkBoxPanel.add(newCheckBox);
    }
    public JPanel getCheckBoxPanel(){ return checkBoxPanel; }

    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        String msg = "";
//        if(cb1.isSelected()){
//            amount+=100;
//            msg="Pizza: 100\n";
//        }

    }

}