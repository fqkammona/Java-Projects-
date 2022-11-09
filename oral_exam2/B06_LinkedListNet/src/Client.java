// Client by Fatima Kammona

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/** This is the client class, it sends
 * what to do with linked list to the server class
 * which then implements it. */

public class Client extends JFrame {
    private JTextField enterField; // for entering messages
    private JTextArea displayArea; // for displaying messages
    private DatagramSocket socket; // socket to connect to server

    private JTextArea instructionArea; // for displaying instructions
    private JTextArea replayArea; // for displaying replay

    private JPanel displayPanel; // The panel that holds the TextAreas
    private JPanel mainPanel = new JPanel(); // holds all the panels in it

    private Container buttonContainer = new Container(); // Container that holds the buttons

    private JButton printListButton = new JButton("Print List");
    private JButton addButton = new JButton("Add Item");
    private JButton deleteButton = new JButton("Delete Item");
    private JButton endButton = new JButton("End Program");
    private GridBagConstraints con = new GridBagConstraints();

    private void fillContainerButtons() {
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));

        printListButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonContainer.add(printListButton);

        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonContainer.add(addButton);

        deleteButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonContainer.add(deleteButton);

        endButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonContainer.add(endButton);

        con.gridx = 0; // first row
        con.gridy = 0; // first col
        con.fill = GridBagConstraints.HORIZONTAL;

        mainPanel.add(buttonContainer, con);
        add(mainPanel); // add to JFrame
    }

    private void fillJPanelDisplayPanel() {

    }

    //  set up GUI and DatagramSocket
    public Client(String host) {
        super("Client");
        mainPanel.setLayout(new GridBagLayout());

        fillContainerButtons();

//
//        enterField = new JTextField("Type message here");
//        enterField.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent event) {
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
//                                    data.length, InetAddress.getByName(host), 23604);
//
//
//                            socket.send(sendPacket); // send packet
//                            displayArea.append("Packet sent\n");
//                            displayArea.setCaretPosition(
//                                    displayArea.getText().length());
//                        } catch (IOException ioException) {
//                            displayMessage(ioException + "\n");
//                            ioException.printStackTrace();
//                        }
//                    }
//                }
//        );
//
//        mainPanel.add(enterField, BorderLayout.NORTH);
//
//        displayArea = new JTextArea();
//        mainPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);


        setSize(400, 300); // set window size
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket();
        } catch (SocketException socketException) {
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
