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

public class Client extends JFrame implements Runnable, ActionListener
 {
   private JTextField enterField; // for entering messages
    private JTextArea displayArea; // for displaying messages
    private Socket socket; // connection to server
    private Scanner input; // input from server
    private Formatter output; // output to server
    private static final Insets insets = new Insets(0,0,0,0);
    private final JTextArea instructionArea = new JTextArea("Output"); // for displaying instructions
    private final JTextArea replayArea = new JTextArea("History"); // for displaying replay
    private final JPanel mainPanel = new JPanel(); // holds all the panels in it
    private final JButton printListButton = new JButton("Print List");
    private final JButton addButton = new JButton("Add Item");
    private final JButton deleteButton = new JButton("Delete Item");
    private final JButton endButton = new JButton("End Program");
    private GridBagConstraints con = new GridBagConstraints();
    private String host;

    private void fillContainerButtons() {
        addButtonComponent(printListButton, 0,1,1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(addButton, 1,1,1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(deleteButton, 2,1,1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(endButton, 3,1,1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addTextAreaComponent(instructionArea, 0,1,2, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addTextAreaComponent(replayArea, 2,1,2, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        add(mainPanel);
    }

    private void addButtonComponent(JButton buttonName,  int gridy, int gridwidth, int gridheight,
                                    int anchor, int fill){
        con = new GridBagConstraints(0, gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,
                insets, 0,0);
        mainPanel.add(buttonName, con);
    }

    private void addTextAreaComponent(JTextArea textAreaName,  int gridy, int gridwidth, int gridheight,
                                    int anchor, int fill){
        con = new GridBagConstraints(1, gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,
                insets, 0,0);
        textAreaName.setEditable(false); // Can't change it
       // mainPanel.add(new JScrollPane(textAreaName), BorderLayout.CENTER);
        mainPanel.add(textAreaName, con);
    }

    //  set up GUI and DatagramSocket
    public Client(String host) {
        super("Client");
        this.host = host;

        mainPanel.setLayout(new GridBagLayout());
        printListButton.addActionListener((ActionListener) this);
        addButton.addActionListener((ActionListener) this);
        deleteButton.addActionListener((ActionListener) this);
        endButton.addActionListener((ActionListener) this);

       fillContainerButtons();

        enterField = new JTextField("Type message here");
        con = new GridBagConstraints(0, 4, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, insets, 0,0);

       mainPanel.add(enterField, con);
       add(mainPanel);

        setSize(400, 300); // set window size
        setVisible(true); // show window

        startClient();
    }

    // start the client thread
    public void startClient()
    {
        try // connect to server and get streams
        {
            // make connection to server
            socket = new Socket(
                    InetAddress.getByName(host), 12345);

            // get streams for input and output
            input = new Scanner(socket.getInputStream());
            output = new Formatter(socket.getOutputStream());
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        // create and start worker thread for this client
        ExecutorService worker = Executors.newFixedThreadPool(1);
        worker.execute(this); // execute client
    }

     public void run()
     {

     }

    public void actionPerformed(ActionEvent e){
        Object buttonPressed = e.getSource();

        if(buttonPressed == printListButton) {
            replayArea.append("\nSending packet containing: " +
                    "print list" + "\n");
            printListButton.setText("clicked");
        } else if (buttonPressed == addButton){
            replayArea.append("\nSending packet containing: " +
                    "add button" + "\n");
        } else if(buttonPressed == deleteButton){
            replayArea.append("\nSending packet containing: " +
                    "delete button" + "\n");
        }
        if (buttonPressed == endButton){
            replayArea.append("\nSending packet containing: " +
                    "end program" + "\n");
        }
    }
//
//    // wait for packets to arrive from Server, display packet contents
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
