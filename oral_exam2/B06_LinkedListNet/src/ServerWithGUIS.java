// ServerWithGUIS.java by Fatima Kammona
/* This is the server that has access to the linked list and will take the response from the
 * client and implement them in the linked list */

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWithGUIS extends JFrame {
    public LinkedList<String> fruitList = new LinkedList<>();
    private final JTextArea displayArea; // display information to user
    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client

    /**
     * This method initializes the fruitList
     * at runtime.
     */
    public void fillList() {
        String[] fruits = {"apple", "grape", "banana", "strawberry", "pineapple"};

        for (String i : fruits)
            fruitList.insetLast(i);
    }

    /**
     * The default constructor that sets up the GUI
     */
    public ServerWithGUIS() {
        super("Server For LinkedList");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window
        fillList(); // fill the linked list
    }

    /**
     * This method sets up and runs the server
     */
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(23603, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get the input and output streams
                    processConnection(); // process connection
                } catch (EOFException eofException)  // Notify the end of the file/stream is reached
                {
                    displayMessage("\nServerWithGUIS terminated connection");
                } finally {
                    closeConnection(); //  close connection
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * This method waits for connection to arrive and then
     * displays the connection information
     */
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection received from: " +
                connection.getInetAddress().getHostName()); // Displays information
    }

    /**
     * This method gets streams to send and receive data
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream()); // sets up the output stream for the objects
        input = new ObjectInputStream(connection.getInputStream()); // sets up the input stream for the objects
    }

    /**
     * This method process the connection with the client
     */
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // send connection successful message

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                optionChoice(message); // Options
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * This method goes through an if statement to find what option was selected and then calls the appropriate
     * method for that option.
     */
    private void optionChoice(String message) throws IOException {
        if (message.compareTo("Print List") == 0) {
            sendData(fruitList.printList());
        }
        if (message.compareTo("Add Button") == 0) {
            addItem();
        }
        if (message.compareTo("Delete Button") == 0) {
            deleteItem();
        }
    }

    /**
     * The add method sends the instructions back to the client and then goes through a while lop until the new
     * item has been added to the linked list.
     */
    private void addItem() throws IOException {
        sendData("Please enter the name of item you would like to be add followed by a comma with the " +
                "word before/after and comma with the reference node" +
                "new node, before/after, reference node ");
        displayMessage("\n" + " Instructions Sent"); // display message
        String message;
        boolean doneAdding = true;

        while (doneAdding) {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                String[] choices = message.split(",", 0);
                fruitList.addNode(choices[0], choices[1], choices[2]);
                sendData("End Add");
                doneAdding = false;
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
                doneAdding = false;
            }
        }
    }

    /**
     * This is method sends the instructions for deleting an item back to the client and then waits in a while
     * loop until the item has been deleted.
     */
    private void deleteItem() throws IOException {
        sendData("\nPlease enter the name of item you would like to be removed.\n");
        String message;
        boolean doneAdding = true;

        while (doneAdding) {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                fruitList.deleteNode(message);
                sendData("End Delete");
                doneAdding = false;
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
                doneAdding = false;
            }
        }
    }

    /**
     * This method closes the streams and socket
     */
    private void closeConnection() {
        displayMessage("\nTerminating connection with Client\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace(); // Prints out where the exception happened
        }
    }

    /**
     * This method uses a try catch block to send messages to the client
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> \n" + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * This method adds the messages sent and received to the displayArea.
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                 /* instead of having an anonymous Runnable() public void run()... we can use () -> ...
                 This public void run updates displayArea  */
                () -> {
                    displayArea.setLineWrap(true);
                    displayArea.append("\n" + messageToDisplay); // append message
                }
        );
    }
}
