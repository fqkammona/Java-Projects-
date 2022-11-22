// exchangeGUI.java by Fatima Kammona
// Creates the exchangeGUI application

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
public class exchangeGUI extends Application {
    public static void main(String[] args) {launch(args);} // launch function calls the start function
    @Override
    public void start(Stage stage) throws Exception {
        URL myfxml = getClass().getResource("exchangeGUIfxml.fxml");
        if(myfxml == null){
            System.out.println("Error");
        }
        else {
            Parent root = FXMLLoader.load(myfxml);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
