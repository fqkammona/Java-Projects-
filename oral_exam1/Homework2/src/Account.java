import java.math.BigDecimal; // For money

public class Account {
    private final int accountNum; // This is final because you should always have the same number
    private BigDecimal balance;

    public Account(int accountNum, BigDecimal balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void updateBalance(BigDecimal balance){
        this.balance = balance;
    }
}
