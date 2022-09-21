import org.junit.jupiter.api.Test;

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

    @Test
    void makingNewAccounts(){ //
        Bank b = new Bank();
        b.makeNewAccount(1,500);

        assertEquals(b.getBalance(), new BigDecimal("500.0"));
    }

    @Test
    void makingMultipleNewAccounts(){ //
        Bank b = new Bank();
        b.makeNewAccount(1,500);
        b.makeNewAccount(2,100);
        b.makeNewAccount(3,50);

        assertEquals(b.getBalance(), new BigDecimal("50.0"));
    }

    @Test
    void exchangeWithoutCurrency(){ // testing exchange methods with BigD and double and without putting currency
        Bank b = new Bank();
        assertEquals(b.getExchangeFromSWD(80), new BigDecimal(Double.toString(80.0)));
        assertEquals(b.getExchangeFromSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(80)));

        assertEquals(b.getExchangeToSWD(80), new BigDecimal(Double.toString(80.0)));
        assertEquals(b.getExchangeToSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(80)));
    }

    @Test
    void makingExchange(){ //
        Bank b = new Bank();
        b.makeNewAccount(1,500);
        b.makeNewAccount(2,530);
        Bank.setCurrency(1.2);

        assertEquals(Bank.getCurrency(), new BigDecimal(Double.toString(1.2)));
    }

    @Test
    void makingMultipleExchange(){ // Tests calling currency from exchange
        Bank.setCurrency(1.2);
        assertEquals(Exchange.getCurrency(), new BigDecimal(Double.toString(1.2)));
        assertEquals(Bank.getCurrency(), new BigDecimal(Double.toString(1.2)));
        assertEquals(Exchange.getCurrency(), new BigDecimal(Double.toString(1.2)));
    }


    @Test
    void exchangeWithCurrency(){ // testing exchange methods with BigD and double and without putting currency
        Bank b = new Bank();
        Bank.setCurrency(1.2);
        assertEquals(b.getExchangeFromSWD(80), new BigDecimal(Double.toString(66.7)));
        assertEquals(b.getExchangeFromSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(66.7)));

        assertEquals(b.getExchangeToSWD(80), new BigDecimal(Double.toString(96.0)));
        assertEquals(b.getExchangeToSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(96.0)));
    }

    @Test
    void differentExchanges(){
        Bank b = new Bank();

        Bank.setCurrency(1.27);
        assertEquals(b.getExchangeFromSWD(80), new BigDecimal(Double.toString(63)));
        assertEquals(b.getExchangeToSWD(80), new BigDecimal(Double.toString(101.6)));

        Bank.setCurrency(0.387);
        assertEquals(b.getExchangeFromSWD(91.25), new BigDecimal(Double.toString(235.79)));
        assertEquals(b.getExchangeToSWD(104.32), new BigDecimal(Double.toString(40.4)));
    }

    @Test
    void differentVerifyWithdraw(){
        Bank b = new Bank();
        b.makeNewAccount(1,500);

        assertEquals(b.verifyWithdraw(new BigDecimal(Double.toString(600))), "Error: not enough money");
        assertEquals(b.verifyWithdraw(new BigDecimal(Double.toString(500))), "");
        assertEquals(b.verifyWithdraw(new BigDecimal(Double.toString(499.99))), "");
    }

    @Test
    void withdrawalBank(){
        Bank b = new Bank();
        b.makeNewAccount(1,500);

        Bank.setCurrency(1.2);
        assertEquals(b.withdrawSWD(80), "3 - 25.0 SWD Bill, \n" +
                "0 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");

        b.makeNewAccount(2,75);

        assertEquals(b.withdrawSWD(300), "Error: not enough money");
        assertEquals(b.withdrawSWD(90), "3 - 25.0 SWD Bill, \n" +
                "1 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");
        assertEquals(b.getBalance(), new BigDecimal(Double.toString(0.00)));
        assertEquals(b.withdrawSWD(0.01), "Error: not enough money");
    }
}
