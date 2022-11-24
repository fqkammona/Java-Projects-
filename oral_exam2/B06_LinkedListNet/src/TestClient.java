// TestClient.java by Fatima Kammona
// This class runs the ClientWithGUIS class application

import javax.swing.JFrame;

public class TestClient {

    public static void main(String[] args) {
        ClientWithGUIS application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new ClientWithGUIS("128.255.17.149"); // localhost
        else
            application = new ClientWithGUIS(args[0]); // use args

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}
