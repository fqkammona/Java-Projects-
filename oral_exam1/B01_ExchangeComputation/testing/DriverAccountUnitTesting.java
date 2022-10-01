import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest; // A method that allows the ability to run a test multiple times
import java.math.BigDecimal;
import org.junit.jupiter.params.provider.CsvSource; // An ArgumentsSource which reads comma separated values from one or more CSV lines


import static org.junit.jupiter.api.Assertions.*;

class DriverAccountUnitTesting {

    @Test // Identifies a method as a test method
    void makingNewAccounts(){
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
    void exchangeWithoutCurrency(){ // Exchange without updating SWD exchange rate.
        Bank b = new Bank();
        assertEquals(b.exchangeCurrency("SWD","USD",80), new BigDecimal("80.00"));
        assertEquals(b.exchangeCurrency("USD","USD",80), new BigDecimal("80.00"));
        assertEquals(b.exchangeCurrency("USD","SWD",80), new BigDecimal("80.00"));
    }

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


    @Test
    void makingMultipleExchange(){ // Tests calling currency from exchange
        Bank bank = new Bank();

        assertEquals(bank.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD"), "SWD currency has been updated");
        assertEquals(bank.getExchangeRate(), new BigDecimal(Double.toString(1.2)));
        assertEquals(bank.upDateCurrency(new BigDecimal(Double.toString(5.789)), "SWD"), "SWD currency has been updated");
        assertEquals(bank.getExchangeRate(), new BigDecimal(Double.toString(5.789)));

    }


    @Test
    void exchangeWithCurrency(){ // testing exchange methods with BigD and double and without putting currency
        Bank b = new Bank();
        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");

        assertEquals(b.exchangeCurrency("USD", "SWD",80), new BigDecimal("96.00"));
        assertEquals(b.exchangeCurrency("SWD", "USD",80), new BigDecimal(Double.toString(66.67)));
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"600, Error: not enough money", "500,''", "499.99,''" })
    void differentVerifyWithdraw(BigDecimal amount, String output){
        Bank b = new Bank();
        b.makeNewAccount(1,500);

        assertEquals(b.verifyWithdraw(amount), output);

    }
    @Test
    void withdrawalBankInSWD(){
        Bank b = new Bank();
        b.makeNewAccount(1,500);

        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");
        assertEquals(b.withdrawalIn("SWD",80), "3 -  25 SWD Bills\n" +
                "1 -  5 SWD Bill\n");

        b.makeNewAccount(2,75);


        assertEquals(b.withdrawalIn("SWD",300), "Error: not enough money");
        assertEquals(b.withdrawalIn("SWD",90), "3 -  25 SWD Bills\n" +
                "1 -  10 SWD Bill\n" +
                "1 -  5 SWD Bill\n");
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
        assertEquals(bank.deleteAccount(21), "45 -  20 Dollar Bills\n");
        assertEquals(bank.findAccount(21), "Error: account was not found.");

    }

    @Test
    void bankStartUpOptions(){
        Bank bank = new Bank();
        assertEquals(bank.bankOptionsAtStartup(), "1. Create new account\n"
                + "2. Log in to account\n"
                + "3. Exchange\n"
                + "4. Set SWD Exchange Rate\n"
                + "5. Exit Program\n"
                + "Enter Choice: ");
    }

    @Test
    void bankOptions(){
        Bank bank = new Bank();
        assertEquals(bank.bankOptions(), "1. Get account information\n"
                + "2. Withdraw\n"
                + "3. Delete Account\n"
                + "4. Log out of Account\n"
                + "5. Log out of Account and Exit Program\n"
                + "Enter Choice: ");

    }

    @Disabled // When the currency given doesn't exist
    void exchangeBetweenFakeCurrency(){
        Bank bank = new Bank();
        BigDecimal amount = bank.exchangeCurrency("MON", "POUND",2);
    }

    @ParameterizedTest // A method that allows the ability to run a test multiple times
    @CsvSource({"MON, Error: Currency not found", "USD,''"})
    void setIllegalCurrency(String currencyName, String output){
        Bank bank = new Bank();
        assertEquals(bank.setMyCurrentCurrency(currencyName), output);

    }
}
