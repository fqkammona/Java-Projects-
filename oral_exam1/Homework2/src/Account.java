import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Account {
    private static double currency = 1;
    private final BigDecimal[] dollars = {
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
        updateBalance(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getWithdraw(double amount1){
        BigDecimal amount = new BigDecimal(Double.toString(getExchangeAmount(amount1)));
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

    /* The method that does the exchange rate and updated it and intizlize balance */
    private void updateBalance(double balance){
        // anoumys var of getEchangeAmount
        this.balance = new BigDecimal(Double.toString(getExchangeAmount(balance)));
    }

    public double getExchangeAmount(double balance){ // This balance has nothing to do with my acutal balance var
        balance = balance * currency;
        return balance;
    }
    public static void setCurrency(double currency) {
        Account.currency = currency;
    }

    public static double getCurrency() {
        return currency;
    }
}
