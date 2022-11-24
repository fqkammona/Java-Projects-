// ClientWithGUIS by Fatima Kammona
/* This is the client class, it sends what to do with linked list to the server class which then implements it. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class ClientWithGUIS extends JFrame implements ActionListener {
    private JTextField enterField; // for entering messages
    private Socket connection; // connection to server
    private String message = ""; // message from server
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private JTextArea instructionArea; // For displaying instructions
    private JTextArea replayArea; // For displaying history
    private final GridBagLayout bagLayout;
    private final JButton printListButton = new JButton("Print List");
    private final JButton addButton = new JButton("Add Item");
    private final JButton deleteButton = new JButton("Delete Item");
    private final JButton endButton = new JButton("End Program");
    private GridBagConstraints constraints = new GridBagConstraints();
    private final String hostAddress; // Stores the IP address
    private final Container container; // The main container for the JFrame that holds the bagLayout

    /**
     * This is the constructor that takes the ip address and stores it in the hostAddress. The constructor is also
     * created and all the of the buttons actionListeners are added and finally the runClient method is called.
     */
    public ClientWithGUIS(String host) {
        super("Client");

        container = getContentPane();
        bagLayout = new GridBagLayout();
        container.setLayout(bagLayout);
        fillContainerButtons();
        this.hostAddress = host;

        printListButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        endButton.addActionListener(this);

        setSize(700, 500); // set window size
        setVisible(true); // show window
        setTextFieldEditable(false);

        runClient();
    }

    /**
     * This method initializes the components and fills the components in the frame.
     */
    private void fillContainerButtons() {
        /*The textArea initializing secction */
        instructionArea = new JTextArea("Instructions", 3, 25);
        constraints.fill = GridBagConstraints.BOTH;
        addComponentText(instructionArea, 1, 0, 2, 1);

        replayArea = new JTextArea("Replay", 9, 25);
        constraints.fill = GridBagConstraints.BOTH;
        addComponentText(replayArea, 1, 1, 2, 4);

        enterField = new JTextField("Type message here");
        constraints.fill = GridBagConstraints.BOTH;
        addComponentText(enterField, 0, 5, 3, 1);

        /* The button initializing section */
        addButtonComponent(printListButton, 0);
        addButtonComponent(addButton, 1);
        addButtonComponent(deleteButton, 2);
        addButtonComponent(endButton, 3);
    }

    /**
     * This method fills the constraints needed to add the components to the container.
     */
    private void addComponentText(Component c, int row, int col, int width, int height) {
        constraints.gridx = row;
        constraints.gridy = col;

        constraints.weighty = 1.0;
        constraints.weightx = 1.0;

        constraints.gridwidth = width;
        constraints.gridheight = height;

        instructionArea.setEditable(false);

        bagLayout.setConstraints(c, constraints);
        container.add(new JScrollPane(c), constraints);
    }

    /**
     * This method implements the construction of a button component given the component and the location on the y-axis,
     * then adds the component with the constraint to the bagLayout which is then added to the mainContainer.
     */
    private void addButtonComponent(Component cName, int gridy) {
        constraints = new GridBagConstraints(0, gridy, 1, 1, 0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        bagLayout.setConstraints(cName, constraints);
        container.add(cName);
    }

    /**
     * This method is the actionPreformed section for all the buttons. It goes through an if statement to find
     * which button is pressed.
     */
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource(); // Create an object of whatever button was pressed

        if (buttonPressed == printListButton) {
            replayArea.append("\nPrinted List\n");
            sendData("Print List");
        } else if (buttonPressed == endButton) {
            closeConnection();
        } else { // For any buttons that use the enterField
            setTextFieldEditable(true);
            if (buttonPressed == addButton) {
                try {
                    addButtonPressed();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (buttonPressed == deleteButton) {
                try {
                    deleteButtonPressed();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            // send message to server
            enterField.addActionListener(
                    /* Instead of having an anonymous ActionListener() public void ... we can use event ->
                     * This is when the enter key is pressed, client sends the message from the textField to the server*/
                    event -> {
                        sendData(event.getActionCommand());
                        setTextFieldEditable(false);
                    }
            );
        }
    }

    /**
     * When the add button is selected, the client will send a message to the server
     * informing it that the add button was pressed and the server will send back the instructions. The instructions
     * will be displayed and the text-field will be editable for the client to send back the required data to add
     * a new item.
     */
    public void addButtonPressed() throws IOException {
        sendData("Add Button");

        /* this is just until I figure out how to get the instructions to print here  */
        instructionArea.setLineWrap(true);
        instructionArea.append("\n\nPlease enter the name of item you would like to be add followed by a comma with the " +
                "word before/after and comma with the reference node" +
                " new node, before/after, reference node \n");
    }

    /**
     * When the delete button is selected, the client will send a message to the server
     * informing it that the delete button was pressed and the server will send back the instructions. The instructions
     * will be displayed and the text-field will be editable for the client to send back the required data to delete
     * an item.
     */
    public void deleteButtonPressed() throws IOException {
        sendData("Delete Button");

        /* this is just until I figure out how to get the instructions to print here  */
        instructionArea.setLineWrap(true);
        instructionArea.append("\n\nPlease enter the name of item you would like to be removed.\n");
    }

    /**
     * In a try catch statement this method connects to the server, gets the streams and process the connection
     */
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * This method creates the socket to make the connection to the server and displays the connection information
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        connection = new Socket(InetAddress.getByName(hostAddress), 23603);

        // display connection information
        displayMessage("Connected to: " + connection.getInetAddress().getHostName());
    }

    /**
     * This method gets streams to send and receive data
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * In a try catch block this method process the connection made with the server
     */
    private void processConnection() throws IOException {

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * This method closes the streams and socket
     */
    private void closeConnection() {
        displayMessage("\nClosing connection");
        // sendData("TERMINATE");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * This is the method that sends the message to the server
     */
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        } catch (IOException ioException) {
            replayArea.append("\nError writing object");
        }
    }

    /**
     * This method allows the messages sent and received to display in the replayArea.
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                /* instead of having an anonymous Runnable() public void run()... we can use () -> ...
                 This public void run updates displayArea  */
                () -> {
                    replayArea.setLineWrap(true); // So the text is cut off nicely
                    replayArea.append(messageToDisplay);
                }
        );
    }

    /**
     * This method allows the user to edit the enterField
     */
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
             /* instead of having an anonymous Runnable() public void run()... we can use () -> ...
                 This public void run updates displayArea  */
                () -> {
                    enterField.setText(""); // making it empty
                    enterField.setEditable(editable); // Sets the enterField to editable
                }
        );
    }
}
