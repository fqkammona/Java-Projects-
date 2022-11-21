// TipCalculatorController.java
// Controller that handles ... events

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    // formatters for currency and percentages
    private Stage stage;
    private Scene scene;
    private Parent root;

    private boolean startBank = true; // to initizlle bank only once
    private Bank bank;

    public void fillBank(){
        bank = new Bank();
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

       if(startBank)
           fillBank();
   }

   // When login button is pressed on the login page
    @FXML
    private void loginAccountButtonPressed(ActionEvent event) throws IOException {
        //  System.out.print("\nPlease enter your bank number: ");
        //                        String foundAccount = bank.findAccount(input.nextInt());
        //                        System.out.println(foundAccount);
        //
        //                        if(foundAccount.compareTo("Account has been found.") == 0){
        //                            System.out.println("You are now logged in");
        //                            logOn = true;
        //                            output = bank.bankOptions();
        //                        }


    }

}

/* ************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
