import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Account {
    private static double currency;
    private final double[] swdDollars = {25, 10, 5, 1, .20, .08, 0.05, 0.01}; // static or no ?

    private BigDecimal[] dollars = {
            new BigDecimal(Double.toString(25)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.20)),
            new BigDecimal(Double.toString(.08)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    private BigDecimal balance;
    private final int accountNum; // This is final because you should always have the same number


    public Account(int accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = new BigDecimal(Double.toString(balance));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getWithdraw(double amount1){
        amount1 = amount1 * currency;
        BigDecimal amount = new BigDecimal(Double.toString(amount1));
        String hold = "";

        if(amount.compareTo(balance) == 1){ // if you try taking more than you have
            return "Error: not enough money";
        }

        /* Subtract balance before we start the withdraw process */
        balance = balance.subtract(amount);

        int i = 0;
        while(amount.compareTo(new BigDecimal(Double.toString(0))) > 0){
            int countBill = 0;
            while(amount.compareTo(dollars[i]) >= 0){
                countBill++;
                amount = amount.subtract(dollars[i]);
            }

            amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN); // This rounds bigDecimal by 2 and rounds up.

            hold = hold + countBill + " - " + dollars[i] + " SWD Bill, \n";
            i++;
        }

        return hold;
    }

    public int getAccountNum() {
        return accountNum;
    }
    public void updateBalance(BigDecimal balance){
        this.balance = balance;
    }

    public static void setCurrency(double currency) {
        Account.currency = currency;
    }

    public static double getCurrency() {
        return currency;
    }
}
