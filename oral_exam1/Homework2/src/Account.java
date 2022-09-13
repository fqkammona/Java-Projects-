import java.math.BigDecimal;
import java.math.RoundingMode;
public class Account {
    private static double currency;
    private final int accountNum; // This is final because you should always have the same number
    private double balance;

    public Account(int accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public double getBalance() {
        BigDecimal changeB =new BigDecimal(balance);
       // return rounded(changeB);
        return balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void updateBalance(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public static void setCurrency(double currency) {
        Account.currency = currency;
    }

    public static double getCurrency() {
        return currency;
    }
}
