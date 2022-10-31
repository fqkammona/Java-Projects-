// Server by Fatima Kammona

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/** This is the server that has access to the
 * linked list and will take the response from the
 * client and implement them in the linked list */

public class Server extends JFrame {
    private JTextArea displayArea; // displays packets received
    private DatagramSocket socket; // socket to connect to client
    public LinkedList<String> fruitList = new LinkedList<>();
    public void fillList(){
        String[] fruits = { "apple", "grape", "banana", "strawberry", "pineapple"};

        for (String i: fruits)
            fruitList.insetLast(i);
    }

    public Server()
    {
        super("Server For LinkedList");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window
        fillList(); // fill the linked list

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket(23604);
        }
        catch (SocketException socketException)
        {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    public void waitForResponse()
    {
        System.out.println("Connected!");


    }

}
