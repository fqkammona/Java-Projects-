import java.math.BigDecimal;
import java.util.ArrayList;

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

    private void updateBalance(BigDecimal amount){
        currentAccount.setBalance(getBalance().subtract(amount));
    }

    public String withdrawSWD(double amount){
        // amount is given in SWD
        // amountAfterExchange is the amount in USD

        /* 1. Amount is given in SWD, so we need to exchange it into USD */
        BigDecimal amountAfterExchange = getExchangeFromSWD(amount);

        /* 2. We need to verify that the amount is less than the balance */
        String output = verifyWithdraw(amountAfterExchange);
        if(!output.equals("")){ return output; }

        /* 3. Update the balance. Balance is always in USD therefor we use the amountAfterExchange to update it */
        updateBalance(amountAfterExchange);

        /* 4. Create a BigDecimal of amount */
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));

        /* 5. We Set the inUSD to false because we want to print in SWD */


        /* 6. We can now call the withdraw method */
        output = getWithdraw(amountBigD, SWDdollars); /// ASK about this.

        return output;
    }

    public String withdrawFromUSDtoSWD(double amount){
        // amount is given in USD
        // amountAfterExchange is the amount in SWD

        /* 1. We need to verify that the amount is less than the balance */
        String output = verifyWithdraw(new BigDecimal(Double.toString(amount)));

        if(!output.equals("")){ return output; }

        /* 2. Amount is given in USD, so we need to exchange it into SWD */
        BigDecimal amountAfterExchange = getExchangeToSWD(amount);

        /* 3. Update the balance. Balance is always in USD therefor we use the amountAfterExchange to update it */
        updateBalance(getExchangeToSWD(amount));

        /* 4. Create a BigDecimal of amount */
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));

        /* 5. We Set the inUSD to false because we want to print in SWD */


        /* 6. We can now call the withdraw method */
        output = getWithdraw(amountBigD, USDdollars); /// ASK about this.

        return output;
    }


}
