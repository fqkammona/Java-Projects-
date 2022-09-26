import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

class DriverAccountUnitTesting {

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

//    @Test
//    void exchangeWithoutCurrency(){ // testing exchange methods with BigD and double and without putting currency
//        Bank b = new Bank();
//        assertEquals(b.getExchangeFromSWD(80), new BigDecimal(Double.toString(80.0)));
//        assertEquals(b.getExchangeFromSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(80)));
//
//        assertEquals(b.getExchangeToSWD(80), new BigDecimal(Double.toString(80.0)));
//        assertEquals(b.getExchangeToSWD(new BigDecimal(Double.toString(80))), new BigDecimal(Double.toString(80)));
//    }

    @Test
    void defaultMyCurrentCurrency(){ // Should be USD
        Bank b = new Bank();
        assertEquals(b.getCurrencyName(), "USD");
        assertEquals(b.getExchangeRate(), new BigDecimal(Double.toString(1.00)));
    }

    @Test
    void defaultPrintList(){ //
        Bank b = new Bank();
        assertEquals(b.printCurrencyList(), "USD: 1.0\n" +
                "CAD: 1.37\n" +
                "SWD: 1.0\n" +
                "POUND: 0.93\n");
    }

    @Test
    void updatingSWDExchange(){ //
        Bank b = new Bank();
        b.makeNewAccount(1,500);
        b.makeNewAccount(2,530);

        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");
        assertEquals(b.getExchangeRate(), new BigDecimal(Double.toString(1.2)));
    }

    @Test
    void exchangeBetweenCurrency(){
        Bank b = new Bank();

        BigDecimal amount = b.exchangeCurrency("CAD", "POUND",2);
        BigDecimal amount1 = b.exchangeCurrency("POUND", "USD",2);

        assertEquals(amount, new BigDecimal("1.36"));
        assertEquals(amount1, new BigDecimal(Double.toString(2.16)));
    }


//    @Test
//    void makingMultipleExchange(){ // Tests calling currency from exchange
//        Bank.setCurrency(1.2);
//        assertEquals(Exchange.getCurrency(), new BigDecimal(Double.toString(1.2)));
//        assertEquals(Bank.getCurrency(), new BigDecimal(Double.toString(1.2)));
//        assertEquals(Exchange.getCurrency(), new BigDecimal(Double.toString(1.2)));
//    }


    @Test
    void exchangeWithCurrency(){ // testing exchange methods with BigD and double and without putting currency
        Bank b = new Bank();
        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");

        assertEquals(b.exchangeCurrency("USD", "SWD",80), new BigDecimal("96.00"));
        assertEquals(b.exchangeCurrency("SWD", "USD",80), new BigDecimal(Double.toString(66.67)));
    }

//    @Test
//    void differentExchanges(){
//        Bank b = new Bank();
//
//        Bank.setCurrency(1.27);
//        assertEquals(b.getExchangeFromSWD(80), new BigDecimal(Double.toString(63)));
//        assertEquals(b.getExchangeToSWD(80), new BigDecimal(Double.toString(101.6)));
//
//        Bank.setCurrency(0.387);
//        assertEquals(b.getExchangeFromSWD(91.25), new BigDecimal(Double.toString(235.79)));
//        assertEquals(b.getExchangeToSWD(104.32), new BigDecimal(Double.toString(40.4)));
//    }

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

        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");
        assertEquals(b.withdrawalIn("SWD",80), "3 - 25.0 SWD Bill, \n" +
                "0 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");

        b.makeNewAccount(2,75);

        assertEquals(b.withdrawalIn("SWD",300), "Error: not enough money");
        assertEquals(b.withdrawalIn("SWD",90), "3 - 25.0 SWD Bill, \n" +
                "1 - 10.0 SWD Bill, \n" +
                "1 - 5.0 SWD Bill, \n");
        assertEquals(b.getBalance(), new BigDecimal("0.00"));
        assertEquals(b.withdrawalIn("SWD",0.01), "Error: not enough money");
    }

    @Test
    void findYourAccount(){
        Bank bank = new Bank();
        bank.makeNewAccount(1,500);
        bank.makeNewAccount(2,900);
        bank.makeNewAccount(3,5.87);
        bank.makeNewAccount(4,3129.98);

        assertEquals(bank.findAccount(1), "Account has been found.");
        assertEquals(bank.getBalance(), new BigDecimal(Double.toString(500)));
        assertEquals(bank.findAccount(89), "Error: account was not found.");
    }

    @Test
    void deleteAccount(){
        Bank bank = new Bank();
        bank.makeNewAccount(1,500);
        bank.makeNewAccount(21,900);
        bank.makeNewAccount(300,5.87);
        bank.makeNewAccount(14,3129.98);

        assertEquals(bank.findAccount(21), "Account has been found.");
        assertEquals(bank.deleteAccount(21), "Account has been deleted.");
        assertEquals(bank.findAccount(21), "Error: account was not found.");

    }
}
