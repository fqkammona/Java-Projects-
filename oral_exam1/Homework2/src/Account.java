import java.math.BigDecimal;
public class Account {
    private static double currency;
    private final int accountNum; // This is final because you should always have the same number
    private double balance;

    public Account(int accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public double getBalance() {
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
}
