// TestServer by Fatima Kammona

import javax.swing.*;

/** This class runs the server class application */
public class TestServer {
    public static void main(String[] args)
    {
        Server application = new Server(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets(); // run server application

//        LinkedList<String> fruitList = new LinkedList<>();
//        String[] fruits = { "apple", "grape", "banana", "strawberry", "pineapple"};
//
//        for (String i: fruits)
//            fruitList.insetLast(i);
//
//        System.out.println(fruitList.printList());
//        fruitList.deleteNode("strawberry");
//
//        System.out.println(fruitList.printList());
    }
}
