import javax.swing.*;
public class DriverQuiz {
    public static void main(String args[])
    {
        JFrame quizFrame = new JFrame("Quiz");

        /* Frame Settings */
        quizFrame.setSize(700,700);
        quizFrame.setLayout(null);
        quizFrame.setVisible(true);

        new Checkbox(quizFrame);


        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends the program when
    }
}
