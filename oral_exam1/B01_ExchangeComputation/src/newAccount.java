import java.math.BigDecimal;


/** This does not need to extend to bank.
 * Account is an account and it can be an account for a bank or for
 * something else. */
public class newAccount {
    private BigDecimal balance;
    private final int accountNum; // This is final because you should always have the same number
    public newAccount(int accountNum1, double balance1){
        this.accountNum = accountNum1;
        this.balance = new BigDecimal(Double.toString(balance1)); // initalize in us dollars
    }

    public int getAccountNum() {
        return accountNum;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
