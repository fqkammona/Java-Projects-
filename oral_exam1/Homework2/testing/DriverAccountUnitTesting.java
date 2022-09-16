import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;



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

        assertEquals(a1.getBalance(), new BigDecimal("500.0"));
        assertEquals(a2.getBalance(), new BigDecimal("300.2345"));
    }

    @Test
    void currency(){
        Account.setCurrency(1.2);
        assertEquals(Account.getCurrency(), 1.2);
        Account.setCurrency(1.5);
        assertEquals(Account.getCurrency(), 1.5);
        Account.setCurrency(1);
        assertEquals(Account.getCurrency(), 1);
    }

    @Test
    void withdrawProcess(){
        Account a1 = new Account(1,500);
        assertEquals(a1.getWithdraw(400), "16 - 25.0 SWD Bill, \n");

    }
}
