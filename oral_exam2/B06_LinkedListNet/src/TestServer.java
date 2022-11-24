// TestServer.java by Fatima Kammona
// This class runs the ServerWithGUIS class application

import javax.swing.*;

public class TestServer {
    public static void main(String[] args) {
        ServerWithGUIS application = new ServerWithGUIS(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}