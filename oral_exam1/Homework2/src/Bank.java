import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Bank {
    ArrayList<newAccount> accounts = new ArrayList<newAccount>();
    private static BigDecimal currency = new BigDecimal(1);
    public newAccount currentAccount;

    public static void setCurrency(double newCurrency) {
        Bank.currency = new BigDecimal(Double.toString(newCurrency));
    }

    public static BigDecimal getCurrency() {
        return currency;
    }

    public void makeNewAccount(int accountNum, double balance){
        currentAccount = new newAccount(accountNum, balance);
        accounts.add(currentAccount);
    }




//
//    private void updateBalance(BigDecimal amount){
//        balance = balance.subtract(amount);
//    }
//
//    private void updateBalance(BigDecimal amount){
//        currentAccount.getBalance()
//    }

}
