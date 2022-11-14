
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;


/** This is the client class, it sends
 * what to do with linked list to the server class
 * which then implements it. */

public class ClientWithGUIS extends JFrame implements ActionListener{
    private JTextField enterField; // for entering messages
    private Socket connection; // connection to server
    private String message = ""; // message from server
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private JTextArea instructionArea; // For displaying instructions
    private JTextArea replayArea; // For displaying history
    private GridBagLayout bagLayout;
    private final JButton printListButton = new JButton("Print List");
    private final JButton addButton = new JButton("Add Item");
    private final JButton deleteButton = new JButton("Delete Item");
    private final JButton endButton = new JButton("End Program");
    private GridBagConstraints con = new GridBagConstraints();
    private String host;
    private Container container;
    public ClientWithGUIS(String host) {
        super("Client");

        container = getContentPane();
        bagLayout = new GridBagLayout();
        container.setLayout(bagLayout);
        fillContainerButtons();
        this.host = host;

        printListButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        endButton.addActionListener(this);
        //enterField.addActionListener(this);

        setSize(700, 500); // set window size
        setVisible(true); // show window
        setTextFieldEditable(false);

        runClient();
    }
    private void fillContainerButtons() {
        instructionArea = new JTextArea("Instructions", 3, 25);
        con.fill = GridBagConstraints.BOTH;
        addComponentText(instructionArea, 1, 0, 2, 1);

        replayArea = new JTextArea("Replay", 9, 25);
        con.fill = GridBagConstraints.BOTH;
        addComponentText(replayArea, 1, 1, 2, 4);

        addButtonComponent(printListButton, 0, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(addButton, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(deleteButton, 2, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);
        addButtonComponent(endButton, 3, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH);

        enterField = new JTextField("Type message here");
        con.fill = GridBagConstraints.BOTH;
        addComponentText(enterField, 0, 5, 3, 1);
    }

    private void addComponentText(Component c, int row, int col, int width, int height) {
        con.gridx = row;
        con.gridy = col;

        con.weighty = 1.0;
        con.weightx = 1.0;

        con.gridwidth = width;
        con.gridheight = height;

        instructionArea.setEditable(false);
        //replayArea.setEditable(false);

        bagLayout.setConstraints(c, con);
        container.add(new JScrollPane(c), con);
    }

    private void addButtonComponent(Component cName, int gridy, int gridwidth, int gridheight,
                                    int anchor, int fill) {
        con = new GridBagConstraints(0, gridy, gridwidth, gridheight, 0, 1.0, anchor, fill,
                insets, 0, 0);
        bagLayout.setConstraints(cName, con);
        container.add(cName);
    }

     public void actionPerformed(ActionEvent e) {
         Object buttonPressed = e.getSource();

         if(buttonPressed == printListButton){
             replayArea.append("\nPrinted List\n");
             sendData("Print List");
         } else if (buttonPressed == endButton){
             closeConnection();
         } else {
             setTextFieldEditable(true);
             if(buttonPressed == addButton){
                 try {
                     addButtonPressed();
                 } catch (IOException ex) {
                     throw new RuntimeException(ex);
                 }
             }
             if(buttonPressed == deleteButton){
                 try {
                     deleteButtonPressed();
                 } catch (IOException ex) {
                     throw new RuntimeException(ex);
                 }
             }

             enterField.addActionListener(
                     new ActionListener()
                     {
                         // send message to server
                         public void actionPerformed(ActionEvent event)
                         {
                             sendData(event.getActionCommand());
                             setTextFieldEditable(false);
                         }
                     }
             );

         }
     }

     /** When the add button is selected, the client will send a message to the server
      * informing it that the add button was pressed and the server will send back the instructions. The instructions
      * will be displayed and the text-field will be editable for the client to send back the required data to add
      * a new item. */
     public void addButtonPressed() throws IOException {
         sendData("Add Button");

         /* this is just until I figure out how to get the instructions to print here  */
         instructionArea.setLineWrap(true);
         instructionArea.append("\n\nPlease enter the name of item you would like to be add followed by a comma with the " +
                 "word before/after and comma with the reference node" +
                 " new node, before/after, reference node \n");
     }

     public void deleteButtonPressed()throws IOException{
         sendData("Delete Button");

         /* this is just until I figure out how to get the instructions to print here  */
         instructionArea.setLineWrap(true);
         instructionArea.append("\n\nPlease enter the name of item you would like to be removed.\n");
     }



    // connect to server and process messages from server
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

    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        connection = new Socket(InetAddress.getByName(host), 23603);

        // display connection information
        displayMessage("Connected to: " +
                connection.getInetAddress().getHostName());
    }

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    // process connection with server
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

    // close streams and socket
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // send message to server
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

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        replayArea.setLineWrap(true);
                        replayArea.append(messageToDisplay);
                    }
                }
        );
    }

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setText(""); // making it empty
                        enterField.setEditable(editable);
                    }
                }
        );
    }

}
