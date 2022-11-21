import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class exchangeGUI extends Application {
    public static void main(String[] args) {launch(args);} // launch function calls the start function

    //1. Create new account - Done
    //2. Log in to account - Done
    //3. Exchange - nah
    //4. Set SWD Exchange Rate
    //5. Exit Program


    //1. Get account information
    //2. Withdraw - Done except for the combobox
    //3. Delete Account
    //4. Log out of Account - Done

    @Override
    public void start(Stage stage) throws Exception {
        URL myfxml = getClass().getResource("exchangeGUIfxml.fxml");
        if(myfxml == null){
            System.out.println("Bad ERROr");
        }
        else {
            Parent root = FXMLLoader.load(myfxml);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
