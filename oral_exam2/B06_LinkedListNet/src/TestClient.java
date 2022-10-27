// TestClient by Fatima Kammona

import javax.swing.*;

/** This class runs the client class application */

public class TestClient {
    public static void main(String[] args)
    {
        Client application = new Client(); // create client
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets(); // run client application
    }
}
