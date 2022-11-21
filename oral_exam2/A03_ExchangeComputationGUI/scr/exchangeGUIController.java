// TipCalculatorController.java
// Controller that handles ... events

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.math.BigDecimal;

public class exchangeGUIController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static Bank bank = new Bank();
    private static int number = 1;
    private int currentAccountNum;

    @FXML // When login button is pressed on the main page
    private void takeMeToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("logInfxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField accountNumber; // TextField for logIn page that holds account number
    @FXML
    private TextField balanceAmount; // TextField for createAccount page that holds balance amount

    @FXML  // When login button is pressed on the login page
    private void loginAccountButtonPressed(ActionEvent event) throws IOException {
        /* This if statement checks
         * 1. If textField accountNumber is empty or null, if so then an alert will be displayed.
         * 2. If accountNumber has any letters in it, if so then an alert will be displayed.
         * 3. If account has not been found then an alert will be displayed.
         * 4. If account has been found then the account page will be displayed.*/

        if (accountNumber.getText() == null || accountNumber.getText().trim().isEmpty()) { // if
            showAlert("Please Enter Number:");
        } else if (!accountNumber.getText().matches("\\d*")) { // if any letters are inserted
            showAlert("Please don't enter letters: ");
        } else { // if a number has actually been entered
            String foundAccount = bank.findAccount(Integer.parseInt(accountNumber.getText()));
            if (foundAccount.compareTo("Account has been found.") == 0) {
                currentAccountNum = bank.getAccountNum();
                takeMeToMainAccountPage(event);
            } else {
                showAlert(foundAccount);
            }
        }
    }

    @FXML  // Takes user to create account page
    private void takeMeToCreateAccountPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("createAccountfxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML  // When create account button is pressed on the createAccount page
    private void createAccountPageButton(ActionEvent event) throws IOException {
        /* This if statement checks
         * 1. If balance is empty or null, if so then an alert will be displayed.
         * 2. If balance has any letters in it or negative, if so then an alert will be displayed.*/

        if (balanceAmount.getText() == null || balanceAmount.getText().trim().isEmpty()) { // if
            showAlert("Please Enter A Number:");
        } else if (!balanceAmount.getText().matches("\\d*")) { // if any letters are inserted
            showAlert("Please don't enter letters or negative numbers: ");
        } else {
            bank.makeNewAccount(number, Double.parseDouble(balanceAmount.getText()));
            currentAccountNum = number;
            number++;
            takeMeToMainAccountPage(event);
        }
    }

    /**
     * This method shows the exchangeGUIfxml scene.
     */
    private void returnToExchangeGUIfxml(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("exchangeGUIfxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField balanceAmountDisplay;

    @FXML
    private TextField numberAccountDisplay = new TextField(String.valueOf(bank.getAccountNum()));

    /**
     * This method shows the mainAccountPagefxml scene.
     */
    private void takeMeToMainAccountPage(ActionEvent event) throws IOException {
        balanceAmountDisplay.setText(bank.getBalance().toString());

        root = FXMLLoader.load(getClass().getResource("mainAccountPagefxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    /**
     * Creates alerts and displays them.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.NONE); // Message box
        alert.setAlertType(Alert.AlertType.ERROR); // set alert type
        alert.setTitle(message);
        alert.show(); // show the dialog
    }

    @FXML  // Returns to the exchangeGUIfxml page
    private void takeMeToExchangeGUIfxml(ActionEvent event) throws IOException {
        returnToExchangeGUIfxml(event);
    }

    @FXML  // Returns to the exchangeGUIfxml page
    private void deleteAccount(ActionEvent event) throws IOException {

        returnToExchangeGUIfxml(event);
    }

    @FXML
    private void takeMeToWithdrawPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("withDrawPagefxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private ComboBox currencyOptions = new ComboBox(FXCollections.observableArrayList("SWD","uSD"));
    @FXML
    private TextField withdrawAmount;

    @FXML
    private TextArea displayWithdraw;

    @FXML
    private void withdrawSubmitButton(ActionEvent event) throws IOException{
        BigDecimal balanceAccount = bank.getBalance();
        BigDecimal withdrawRequest = new BigDecimal(Double.parseDouble(withdrawAmount.getText()));

        if(balanceAccount.compareTo(withdrawRequest) < 0){
            showAlert("Not enough money");
        } else {
            displayWithdraw.setText(bank.withdrawalIn("SWD", Double.parseDouble(withdrawAmount.getText())));
        }
    }

    @FXML
    private void takeMeToMainPageButton(ActionEvent event) throws IOException{
        takeMeToMainAccountPage(event);
    }

    @FXML  // Takes user to create account page
    private void takeMeToswdExchangeRate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("swdExchangeRatefxml.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField swdRate;
    @FXML
    private TextArea displayOutput;
    @FXML  // Takes user to create account page
    private void submitSetswdRate(ActionEvent event) throws IOException {
        BigDecimal swdRequest = BigDecimal.valueOf(Double.parseDouble(swdRate.getText()));
        displayOutput.setText(bank.upDateCurrency(swdRequest,"SWD"));
    }

}
