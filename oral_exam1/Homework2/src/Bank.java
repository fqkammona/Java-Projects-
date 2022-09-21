import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Bank extends Exchange {
    ArrayList<newAccount> accounts = new ArrayList<newAccount>();

    public newAccount currentAccount;

//    public static void setCurrency(double newCurrency) {
//        Exchange.setCurrency(newCurrency);
//
//    }

//    public static BigDecimal getCurrency() {
//        return Exchange.getCurrency();
//    }

    public void makeNewAccount(int accountNum, double balance){
        currentAccount = new newAccount(accountNum, balance);
        accounts.add(currentAccount);
    }

    public BigDecimal getBalance(){
        return currentAccount.getBalance();
    }

    public int getAccountNum() {
        return currentAccount.getAccountNum();
    }

}
