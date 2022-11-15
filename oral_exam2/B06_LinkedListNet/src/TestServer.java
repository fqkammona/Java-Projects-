// TestServer by Fatima Kammona

import javax.swing.*;

/** This class runs the ServerWithGUIS class application */
public class TestServer {
    public static void main(String[] args)
    {
        ServerWithGUIS application = new ServerWithGUIS(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}

// Spacing in the server
//  Spacing in the arrows
// Why do i have to press close connection twice ?