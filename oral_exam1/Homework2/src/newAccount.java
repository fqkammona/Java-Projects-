import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class newAccount extends Bank {
    private BigDecimal balance;
    private final int accountNum; // This is final because you should always have the same number
    public newAccount(int accountNum1, double balance1){
        this.accountNum = accountNum1;
        this.balance = new BigDecimal(Double.toString(balance1)); // initalize in us dollars

    }
    @Override
    public int getAccountNum() {
        return accountNum;
    }

  @Override
    public BigDecimal getBalance(){
        return balance;
    }

}
