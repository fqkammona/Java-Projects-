// TestClient by Fatima Kammona

import javax.swing.*;
import javax.swing.JFrame;


/** This class runs the client class application */

public class TestClient {

//    public static void main(String[] args)
//    {
//        Client application; // declare client application
//
//        // if no command line args
//        if (args.length == 0)
//            application = new Client("127.0.0.1"); // localhost
//        else
//            application = new Client(args[0]); // use args
//
//        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    public static void main(String[] args)
    {
        ClientWithGUIS application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new ClientWithGUIS("128.255.17.113"); // localhost
        else
            application = new ClientWithGUIS(args[0]); // use args

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}  // end class ClientTest
