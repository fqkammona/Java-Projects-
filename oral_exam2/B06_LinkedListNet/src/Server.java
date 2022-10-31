// Server by Fatima Kammona

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/** This is the server that has access to the
 * linked list and will take the response from the
 * client and implement them in the linked list */

public class Server extends JFrame {
    private JTextArea displayArea; // displays packets received
    private DatagramSocket socket; // socket to connect to client
    public LinkedList<String> fruitList = new LinkedList<>();

    public String[] menuOptions = {"1. Print List", "2. Add Item", "3. Delete Item", "4. End program"};

    public String stringOfMenuOptions(){
        StringBuilder menuOptionString = new StringBuilder();

        for (String i: menuOptions)
            menuOptionString.append(i).append("\n");

        return menuOptionString.toString();
    }

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

    // wait for packets to arrive, display data and echo packet to client
    public void waitForPackets()
    {
        while (true)
        {
            try // receive packet, display contents, return copy to client
            {

                byte[] data = new byte[100]; // set up packet
                DatagramPacket receivePacket =
                        new DatagramPacket(data, data.length);

                socket.receive(receivePacket); // wait to receive packet

                // display information from received packet
                displayMessage("\nPacket received:" +
                        "\nFrom host: " + receivePacket.getAddress() +
                        "\nHost port: " + receivePacket.getPort() +
                        "\nLength: " + receivePacket.getLength() +
                        "\nContaining:\n\t" + new String(receivePacket.getData(),
                        0, receivePacket.getLength()));

               // sendPacketToClient(receivePacket); // send packet to client
                sendOptions(receivePacket);
            }
            catch (IOException ioException)
            {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
    }

    /** Sends packet to the client of menu options */
    private void sendOptions(DatagramPacket receivePacket)
            throws IOException
    {
        displayMessage("\nList Sent");

        byte[] data = stringOfMenuOptions().getBytes(); // converts the string to bytes

        /* Creates a packet to send back with the string of menu options */
        DatagramPacket sendPacket = new DatagramPacket(
                data, data.length,
                receivePacket.getAddress(), receivePacket.getPort());


        socket.send(sendPacket); // Sends the packet
        displayMessage("Packet sent\n");

    }


    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // display message
                    }
                }
        );
    }
}


