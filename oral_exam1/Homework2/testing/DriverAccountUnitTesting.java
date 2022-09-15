import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DriverAccountUnitTesting {

    @Test
    void constructor(){ // Tests Creating A new account using the constructor
        Account a1 = new Account(1,500);
        Account a2 = new Account(2,300);

        assertEquals(a1.getAccountNum(), 1);
        assertEquals(a2.getAccountNum(), 2);
    }

    @Test
    void bigDecimal(){ // Testing the balance
        Account a1 = new Account(1,500);
        Account a2 = new Account(2,300.2345);

        assertEquals(a1.getBalance(), 500);
        assertEquals(a2.getBalance(), 300.2345);
    }

    @Test
    void currency(){
        Account.setCurrency(1.2);
        assertEquals(Account.getCurrency(), 1.2);
    }

    @Test
    void withdrawProcess(){
        Account a1 = new Account(1,500);
     //   assertEquals(a1.Withdraw(300), "8 SWD Bill");
    }
}
