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

    boolean displayMenu = true;
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

            optionChoice(receivePacket);
            }
            catch (IOException ioException)
            {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
    }

    private void optionChoice(DatagramPacket receivePacket)
        throws IOException
    {
        /* Converts they byte data to a string and then converts the string into an int */
        int choiceNumber = Integer.parseInt(new String(receivePacket.getData(),
                receivePacket.getOffset(),receivePacket.getLength())); // String to Int

        switch (choiceNumber){
            case 1: // print list
                sendPrintOfList(receivePacket);
                break;
            case 2: // Add Item
                displayMenu = false;
                addItem(receivePacket);
                break;
            case 3: // Remove Item
                displayMenu = false;
                removeItem(receivePacket);
                sendPrintOfList(receivePacket);
                break;
            case 4: // End program
                break;
            default: displayMenu = true;
                break;
        }

        /* Sends menu options to the client  */
        if(displayMenu)
            sendMessage(receivePacket, stringOfMenuOptions().getBytes(), "\nList of menu options sent");
    }

    private void addItem(DatagramPacket receivePacket)
            throws IOException
    {
        sendMessage(receivePacket, "Please enter the name of \nitem you would like to be add.".getBytes(),
                "\nWhich Item to remove: ");

        while (!displayMenu)
        {
            try // receive packet, display contents, return copy to client
            {

                byte[] dataResponse = new byte[100]; // set up packet
                DatagramPacket responsePacket =
                        new DatagramPacket(dataResponse, dataResponse.length);

                socket.receive(responsePacket); // wait to receive packet

                // display information from received packet
                displayMessage("\nPacket received:" +
                        "\nFrom host: " + responsePacket.getAddress() +
                        "\nHost port: " + responsePacket.getPort() +
                        "\nLength: " + responsePacket.getLength() +
                        "\nContaining:\n\t" + new String(responsePacket.getData(),
                        0, responsePacket.getLength()));


                /* You need to get the buffer length  */
                String choice = new String(responsePacket.getData(), 0 ,responsePacket.getLength());

                fruitList.deleteNode(choice);

                displayMenu = true;
            }
            catch (IOException ioException)
            {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
    }


    /** A method that sends the printed out linked list to the client. */
    private void removeItem(DatagramPacket receivePacket)
            throws IOException
    {
        sendMessage(receivePacket, "Please enter the name of \nitem you would like to be removed.".getBytes(),
                "\nWhich Item to remove: ");

        while (!displayMenu)
        {
            try // receive packet, display contents, return copy to client
            {

                byte[] dataResponse = new byte[100]; // set up packet
                DatagramPacket responsePacket =
                        new DatagramPacket(dataResponse, dataResponse.length);

                socket.receive(responsePacket); // wait to receive packet

                // display information from received packet
                displayMessage("\nPacket received:" +
                        "\nFrom host: " + responsePacket.getAddress() +
                        "\nHost port: " + responsePacket.getPort() +
                        "\nLength: " + responsePacket.getLength() +
                        "\nContaining:\n\t" + new String(responsePacket.getData(),
                        0, responsePacket.getLength()));


                /* You need to get the buffer length  */
                String choice = new String(responsePacket.getData(), 0 ,responsePacket.getLength());

                fruitList.deleteNode(choice);

                displayMenu = true;
            }
            catch (IOException ioException)
            {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
    }

    /** A method that sends the printed out linked list to the client. */
    private void sendPrintOfList(DatagramPacket receivePacket)
            throws IOException
    {
        sendMessage(receivePacket, fruitList.printList().getBytes(), "\nPrinted out linked list sent");
    }

    /** This is the only method that actually sends the data to the client. Rather than writing this
     * very time all methods sends call this method when they want to send data to the client.   */
    private void sendMessage(DatagramPacket receivePacket, byte[] data, String message)
            throws IOException
    {
        displayMessage(message);

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


