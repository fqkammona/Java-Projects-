// Client by Fatima Kammona

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** This is the client class, it sends
 * what to do with linked list to the server class
 * which then implements it. */

//public class Client extends JFrame
// {
//   private JTextField enterField; // for entering messages
//    private JTextArea displayArea; // for displaying messages
//    private DatagramSocket socket; // connection to server
////    private Scanner input; // input from server
////    private Formatter output; // output to server
//    private static final Insets insets = new Insets(0,0,0,0);
//     private JTextArea instructionArea; // For displaying instructions
//     private JTextArea replayArea; // For displaying history
//    private GridBagLayout bagLayout;
//    private final JButton printListButton = new JButton("Print List");
//    private final JButton addButton = new JButton("Add Item");
//    private final JButton deleteButton = new JButton("Delete Item");
//    private final JButton endButton = new JButton("End Program");
//    private GridBagConstraints con = new GridBagConstraints();
//
//    private Container container;
//
//    private void fillContainerButtons() {
//        instructionArea = new JTextArea("Instructions", 3,25);
//        con.fill = GridBagConstraints.BOTH;
//        addComponentText(instructionArea, 1,0, 2, 1);
//
//        replayArea = new JTextArea("Replay", 9,25);
//        con.fill = GridBagConstraints.BOTH;
//        addComponentText(replayArea, 1,1, 2, 4);
//
//        addButtonComponent(printListButton, 0,1,1, GridBagConstraints.CENTER,
//                GridBagConstraints.BOTH);
//        addButtonComponent(addButton, 1,1,1, GridBagConstraints.CENTER,
//                GridBagConstraints.BOTH);
//        addButtonComponent(deleteButton, 2,1,1, GridBagConstraints.CENTER,
//                GridBagConstraints.BOTH);
//        addButtonComponent(endButton, 3,1,1, GridBagConstraints.CENTER,
//                GridBagConstraints.BOTH);
//
//        enterField = new JTextField("Type message here");
//        con.fill = GridBagConstraints.BOTH;
//        addComponentText(enterField, 0,5,3,1);
//    }
//
//    private void addComponentText(Component c, int row, int col, int width, int height){
//        con.gridx = row;
//        con.gridy = col;
//
//        con.weighty = 1.0;
//        con.weightx = 1.0;
//
//        con.gridwidth = width;
//        con.gridheight = height;
//
//        instructionArea.setEditable(false);
//       // replayArea.setEditable(false);
//
//        bagLayout.setConstraints(c, con);
//        container.add(new JScrollPane(c), con);
//    }
//    private void addButtonComponent(Component cName,  int gridy, int gridwidth, int gridheight,
//                                    int anchor, int fill){
//        con = new GridBagConstraints(0, gridy, gridwidth, gridheight, 0, 1.0, anchor, fill,
//                insets, 0,0);
//        bagLayout.setConstraints(cName, con);
//        container.add(cName);
//    }
//
//
//    //  set up GUI and DatagramSocket
//    public Client() {
//        super("Client");
//
//        container = getContentPane();
//        bagLayout = new GridBagLayout();
//        container.setLayout(bagLayout);
//        fillContainerButtons();
//
////        printListButton.addActionListener(this);
////        addButton.addActionListener(this);
////        deleteButton.addActionListener(this);
////        endButton.addActionListener(this);
//        enterField.addActionListener(
//                new ActionListener()
//                {
//                    public void actionPerformed(ActionEvent event)
//                    {
//                        try // create and send packet
//                        {
//                            // get message from textfield
//                            String message = event.getActionCommand();
//                            displayArea.append("\nSending packet containing: " +
//                                    message + "\n");
//
//                            byte[] data = message.getBytes(); // convert to bytes
//
//                            // create sendPacket
//                            DatagramPacket sendPacket = new DatagramPacket(data,
//                                    data.length, InetAddress.getByName("128.255.17.113"), 23604);
//
//
//                            socket.send(sendPacket); // send packet
//                            displayArea.append("Packet sent\n");
//                            displayArea.setCaretPosition(
//                                    displayArea.getText().length());
//                        }
//                        catch (IOException ioException)
//                        {
//                            displayMessage(ioException + "\n");
//                            ioException.printStackTrace();
//                        }
//                    }
//                }
//        );
//
//        setSize(450, 500); // set window size
//        setVisible(true); // show window
//
//        waitForPackets();
//
//        try // create DatagramSocket for sending and receiving packets
//        {
//            socket = new DatagramSocket();
//        }
//        catch (SocketException socketException)
//        {
//            socketException.printStackTrace();
//            System.exit(1);
//        }
//
//    }
//
////     public void actionPerformed(ActionEvent e)
////     {
////         try // create and send packet
////         {
////             // get message from textfield
////             String message = "1";
////             displayArea.append("\nSending packet containing: " +
////                     message + "\n");
////
////             byte[] data = message.getBytes(); // convert to bytes
////
////             // create sendPacket
////             DatagramPacket sendPacket = new DatagramPacket(data,
////                     data.length, InetAddress.getByName(host), 23604);
////
////
////             socket.send(sendPacket); // send packet
////             displayArea.append("Packet sent\n");
////             displayArea.setCaretPosition(
////                     displayArea.getText().length());
////         }
////         catch (IOException ioException)
////         {
////             displayMessage(ioException + "\n");
////             ioException.printStackTrace();
////         }
////     }
//
////     public void actionPerformed(ActionEvent e) {
////        Object buttonPressed = e.getSource();
////        String message = "1";
////
////        byte[] data = message.getBytes(); // convert to bytes
////
////        DatagramPacket sendPacket = new DatagramPacket(data,
////                data.length, InetAddress.getByName(host), 23935);
////
////        if(buttonPressed == printListButton) {
////            displayArea.append("\nSending packet containing: " +
////                    "Print List" + "\n");
////
////
////        } else if (buttonPressed == addButton){
////            instructionArea.append("\nSending packet containing: " +
////                    "print list" + "\n");
////            replayArea.append("\nSending packet containing: " +
////                    "add button" + "\n");
////        } else if(buttonPressed == deleteButton){
////            replayArea.append("\nSending packet containing: " +
////                    "delete button" + "\n");
////        }
////        if (buttonPressed == endButton){
////            replayArea.append("\nSending packet containing: " +
////                    "end program" + "\n");
////        }
////    }
//
////
////    // wait for packets to arrive from Server, display packet contents
//    public void waitForPackets()
//    {
//        while (true)
//        {
//            try // receive packet and display contents
//            {
//                byte[] data = new byte[100]; // set up packet
//                DatagramPacket receivePacket = new DatagramPacket(
//                        data, data.length);
//
//                socket.receive(receivePacket); // wait for packet
//
//                // display packet contents
//                displayMessage("\nPacket received:" +
//                        "\nFrom host: " + receivePacket.getAddress() +
//                        "\nHost port: " + receivePacket.getPort() +
//                        "\nLength: " + receivePacket.getLength() +
//                        "\nContaining:\n\t" + new String(receivePacket.getData(),
//                        0, receivePacket.getLength()));
//            }
//            catch (IOException exception)
//            {
//                displayMessage(exception + "\n");
//                exception.printStackTrace();
//            }
//        }
//    }
//    private void sendMessage(DatagramPacket receivePacket, byte[] data, String message)
//        throws IOException
//    {
//        displayMessage(message);
//
//        /* Creates a packet to send back with the string of menu options */
//        DatagramPacket sendPacket = new DatagramPacket(
//            data, data.length,
//            receivePacket.getAddress(), receivePacket.getPort());
//
//
//        socket.send(sendPacket); // Sends the packet
//        displayMessage("Packet sent\n");
//    }

    // manipulates displayArea in the event-dispatch thread
//    private void displayMessage(final String messageToDisplay)
//    {
//        SwingUtilities.invokeLater(
//                new Runnable()
//                {
//                    public void run() // updates displayArea
//                    {
//                        replayArea.append(messageToDisplay);
//                    }
//                }
//        );
//    }

//}

public class Client extends JFrame
{
    private JTextField enterField; // for entering messages
    private JTextArea displayArea; // for displaying messages
    private DatagramSocket socket; // socket to connect to server

//    private Scanner input; // input from server
//    private Formatter output; // output to server
    private static final Insets insets = new Insets(0,0,0,0);
     private JTextArea instructionArea; // For displaying instructions
     private JTextArea replayArea; // For displaying history
    private GridBagLayout bagLayout;
    private final JButton printListButton = new JButton("Print List");
    private final JButton addButton = new JButton("Add Item");
    private final JButton deleteButton = new JButton("Delete Item");
    private final JButton endButton = new JButton("End Program");
    private GridBagConstraints con = new GridBagConstraints();
    private Container container;

    // set up GUI and DatagramSocket

    public void addComponentText(Component c, int row, int col, int width, int height){
        con.gridx = row;
        con.gridy = col;

        con.weighty = 1.0;
        con.weightx = 1.0;

        con.gridwidth = width;
        con.gridheight = height;

        //instructionArea.setEditable(false);
       // replayArea.setEditable(false);

        bagLayout.setConstraints(c, con);
        container.add(new JScrollPane(c), con);
    }

    private void tryThis(){
        enterField = new JTextField("Type message here");
        con.fill = GridBagConstraints.BOTH;
        addComponentText(enterField, 0,5,3,1);

    }
    public Client(String host)
    {
        super("Client");

        container = getContentPane();
       bagLayout = new GridBagLayout();
       container.setLayout(bagLayout);

       tryThis();
        //enterField = new JTextField("Type message here");


        enterField.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        try // create and send packet
                        {
                            // get message from textfield
                            String message = event.getActionCommand();
                            displayArea.append("\nSending packet containing: " +
                                    message + "\n");

                            byte[] data = message.getBytes(); // convert to bytes

                            // create sendPacket
                            DatagramPacket sendPacket = new DatagramPacket(data,
                                    data.length, InetAddress.getByName("128.255.17.113"), 23603);


                            socket.send(sendPacket); // send packet
                            displayArea.append("Packet sent\n");
                            displayArea.setCaretPosition(
                                    displayArea.getText().length());
                        }
                        catch (IOException ioException)
                        {
                            displayMessage(ioException + "\n");
                            ioException.printStackTrace();
                        }
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(400, 300); // set window size
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket();
        }
        catch (SocketException socketException)
        {
            socketException.printStackTrace();
            System.exit(1);
        }
        waitForPackets();
    }

    // wait for packets to arrive from Server, display packet contents
    public void waitForPackets()
    {
        while (true)
        {
            try // receive packet and display contents
            {
                byte[] data = new byte[100]; // set up packet
                DatagramPacket receivePacket = new DatagramPacket(
                        data, data.length);

                socket.receive(receivePacket); // wait for packet

                // display packet contents
                displayMessage("\nPacket received:" +
                        "\nFrom host: " + receivePacket.getAddress() +
                        "\nHost port: " + receivePacket.getPort() +
                        "\nLength: " + receivePacket.getLength() +
                        "\nContaining:\n\t" + new String(receivePacket.getData(),
                        0, receivePacket.getLength()));
            }
            catch (IOException exception)
            {
                displayMessage(exception + "\n");
                exception.printStackTrace();
            }
        }
    }

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }
}
