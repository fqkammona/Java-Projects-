// TipCalculatorController.java
// Controller that handles ... events

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;

public class exchangeGUIController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private boolean startBank = true; // to initizlle bank only once
    public static Bank bank = new Bank();

    public void fillBank(){
        bank.makeNewAccount(1,300);
        bank.makeNewAccount(2,1209.13);
        bank.makeNewAccount(3,10.0);
        startBank = false;
    }
    // When login button is pressed on the main page
   @FXML
   private void loginButtonPressed(ActionEvent event) throws IOException {
       root = FXMLLoader.load(getClass().getResource("logInfxml.fxml"));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();

     //  fillBank();
//       if(startBank)
//           fillBank();
   }

   @FXML
   private TextField accountNumber; // TextField for logIn page that holds account number

    @FXML  // When login button is pressed on the login page
    private void loginAccountButtonPressed(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE); // Message box

        /* This if statement checks
        * 1. If textField accountNumber is empty or null, if so then an alert will be displayed.
        * 2. If accountNumber has any letters in it, if so then an alert will be displayed.
        * 3. If account has not been found then an alert will be displayed.
        * 4. If account has been found then the account page will be displayed.*/

        if (accountNumber.getText() == null || accountNumber.getText().trim().isEmpty()) { // if
            alert.setAlertType(Alert.AlertType.ERROR); // set alert type
            alert.setTitle("Please Enter Number: ");
            alert.show(); // show the dialog
        }
        else if(!accountNumber.getText().matches("\\d*")){ // if any letters are inserted
            alert.setAlertType(Alert.AlertType.ERROR); // set alert type
            alert.setTitle("Please don't enter letters: ");
            alert.show(); // show the dialog
        }
        else { // if a number has actually been entered
            String foundAccount = bank.findAccount(Integer.parseInt(accountNumber.getText()));

            if(foundAccount.compareTo("Account has been found.") == 0){
                alert.setAlertType(Alert.AlertType.ERROR); // set alert type
                alert.setTitle("You are now logged in");
                alert.show(); // show the dialog
            } else {
                alert.setAlertType(Alert.AlertType.ERROR); // set alert type
                alert.setTitle(foundAccount);
                alert.show(); // show the dialog
            }
        }
    }

    @FXML  // When login button is pressed on the login page
    private void createAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("exchangeGUIfxml.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
