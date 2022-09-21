import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class Bank extends Exchange {
    ArrayList<newAccount> accounts = new ArrayList<newAccount>();

    public newAccount currentAccount;

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

    public String verifyWithdraw(BigDecimal amount){
        if(amount.compareTo(currentAccount.getBalance()) == 1){ // if you try taking more than you have
            return "Error: not enough money";
        }
        return "";
    }
}
