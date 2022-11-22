// exchangeGUIController.java by Fatima Kammona
// Controller that handles all the events

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class exchangeGUIController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static Bank bank = new Bank();
    private static int number = 1;

    /**
     * This is the ActionEvent section for the exchangeGUIfxml page.
     * Actions for the login button, create new account and set SWD rate.
     * */
    @FXML // When login button is pressed on the main page
    private void takeMeToLoginPage(ActionEvent event) throws IOException {
        // Use objects because getResource could be null
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInfxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML // When create new account button is pressed on the main page
    private void takeMeToCreateAccountPage(ActionEvent event) throws IOException {
        // Use objects because getResource could be null
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createAccountfxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML  // When Set SWD Rate is button is pressed
    private void takeMeToswdExchangeRate(ActionEvent event) throws IOException {
        // Use objects because getResource could be null
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("swdExchangeRatefxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This section holds methods that are called often
     * */

    /* This method creates and displays an alert box of the message given.*/
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.NONE); // Message box
        alert.setAlertType(Alert.AlertType.ERROR); // set alert type
        alert.setTitle(message);
        alert.show(); // show the dialog
    }

    /*  This method shows the exchangeGUIfxml scene.  */
    private void returnToExchangeGUIfxml(ActionEvent event) throws IOException {
        // use object because the fxml could be null
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exchangeGUIfxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML  // This is the ActionEvent for any button that returns to the exchangeGUIfxml
    private void takeMeToExchangeGUIfxml(ActionEvent event) throws IOException {
        returnToExchangeGUIfxml(event);
    }

    /*This method shows the mainAccountPagefxml scene. */
    private void returnToMainAccountfxml(ActionEvent event) throws IOException {
        // Use objects because getResource could be null
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainAccountPagefxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML // This is the ActionEvent for any button that returns to the mainAccountPagefxml
    private void takeMeToMainAccountfxml(ActionEvent event) throws IOException{
        returnToMainAccountfxml(event);
    }

    /**
     * This section is all the methods and instance variables for the logInfxml.fxml page
     */
    @FXML
    private TextField accountNumber; // TextField for logIn page that holds account number
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
                takeMeToMainAccountfxml(event);
            } else {
                showAlert(foundAccount);
            }
        }
    }

    /**
     * This section is all the methods and instance variables for the createAccountfxml.fxml page
     */
    @FXML
    private TextField balanceAmount; // TextField for createAccount page that holds balance amount
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
            number++;
            takeMeToMainAccountfxml(event);
        }
    }

    /**
     * This section is the method and instance variables for the swdExchangeRatefxml.fxml page
     */
    @FXML
    private TextField swdRate; // TextField where the user will put the number
    @FXML
    private TextArea displayOutput; // Will display a message updating the user
    @FXML  //When Submit button is pressed on the swdExchangeRatefxml page
    private void submitSetswdRate(ActionEvent ignoredEvent) {
        BigDecimal swdRequest = BigDecimal.valueOf(Double.parseDouble(swdRate.getText()));
        displayOutput.setText(bank.upDateCurrency(swdRequest,"SWD"));
    }

    /**
     * This is the ActionEvent section for the mainAccountPagefxml page.
     * Actions for the withdrawal and delete account buttons.
     */
    @FXML //  When withdraw button is pressed
    private void takeMeToWithdrawPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("withDrawPagefxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML //  When delete account button is pressed
    private void deleteAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteAccountfxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This section is the method and instance variables for the withDrawPagefxml.fxml page
     */
    @FXML
    private TextField withdrawAmount; // The TextField where the sure enters the amount they wish to withdraw
    @FXML
    private TextArea displayWithdraw; // Displays the amount of bills needed
    @FXML // When the submit request button for the withdrawal is pressed
    private void withdrawSubmitButton(ActionEvent ignoredEvent) {
        BigDecimal balanceAccount = bank.getBalance();
        BigDecimal withdrawRequest = BigDecimal.valueOf(Double.parseDouble(withdrawAmount.getText()));
        if(balanceAccount.compareTo(withdrawRequest) < 0){
            showAlert("Not enough money");
        } else {
            displayWithdraw.setText(bank.withdrawalIn("SWD", Double.parseDouble(withdrawAmount.getText())));
        }
    }

    /**
     * This section is the method and instance variables for the deleteAccountfxml.fxml page
     */
    @FXML
    private TextArea accountInformationDisplay; // Displays the amount of SWD to return
    @FXML
    private Button deleteButton;
    @FXML
    private Button returnHome; // return to mainAccountPagefxml.fxml page
    @FXML
    private Button takeHomeDeleteOne; // return to exchangeGUIfxml.fxml page

    /* The user has the options to either,
    * 1. delete account or return to mainAccountPagefxml.fxml page
    * 2. delete account and return to exchangeGUIfxml.fxml page  */
    @FXML
    private void deleteThisAccount(ActionEvent ignoredEvent) {
        accountInformationDisplay.setText(bank.deleteAccount(bank.getAccountNum()));
        returnHome.setVisible(true);
        deleteButton.setDisable(true);
        takeHomeDeleteOne.setDisable(true);
        showAlert("Account Has been deleted");
    }

    /**
     *  This section holds the ActionEvent for when the account information button is pressed on the
     *  mainAccountPagefxml.fxml page is pressed.
     */
    @FXML
    private Label accountBalanceDisplay; // Displays the balance for the account
    @FXML
    private Label accountNumberDisplay; // Displays the number for the account
    @FXML
    private void accountInformation(ActionEvent ignoredEvent) {
        accountNumberDisplay.isDisable();
        accountBalanceDisplay.isDisable();
        accountBalanceDisplay.setText(bank.getBalance().toString());
        accountNumberDisplay.setText(String.valueOf(bank.getAccountNum()));
    }
}
