import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;


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
        Account account1 = new Account(1,500);
        Account account2 = new Account(2,300.2345);

        assertEquals(account1.getBalance(), new BigDecimal("500.0"));
        assertEquals(account2.getBalance(), new BigDecimal("300.2345"));
    }

    @Test
    void testWithdrawSWD(){
        Account account1 = new Account(1,500);
        Account account2 = new Account(2,75); // test withdrawl negative

        Account.setCurrency(1.2);
        assertEquals(account1.withdrawSWD(80), "3 - 25.0 SWD Bill, \n" +
                "0 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");
        assertEquals(account2.withdrawSWD(300), "Error: not enough money");
        assertEquals(account2.withdrawSWD(90), "3 - 25.0 SWD Bill, \n" +
                "1 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");
        assertEquals(account2.getBalance(), new BigDecimal(Double.toString(0.00)));
        assertEquals(account2.withdrawSWD(0.01), "Error: not enough money");
    }


    @Test
    void settingAndGettingCurrency(){
        Account.setCurrency(1.21);
        assertEquals(Account.getCurrency(), new BigDecimal(Double.toString(1.21)));
        Account.setCurrency(15);
        assertEquals(Account.getCurrency(), new BigDecimal(Double.toString(15.0)));
        Account.setCurrency(1);
        assertEquals(Account.getCurrency(), new BigDecimal(Double.toString(1.0)));
    }

    /** This test the different methods of exchangeFromSWD and makes sures the balance never changes */
    @Test
    void differentExchangeFromSWD(){
        Account account1 = new Account(1,500);
        Account.setCurrency(1.2);
        assertEquals(account1.getExchangeFromSWD(80), new BigDecimal(Double.toString(66.7)));
        assertEquals(account1.getExchangeFromSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(66.7)));
        assertEquals(account1.getBalance(), new BigDecimal(Double.toString(500)));
    }

    @Test
    void delete(){
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account account1 = new Account(1,500);
        accounts.add(account1);
        accounts.remove(account1);
    }

}
