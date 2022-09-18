import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class Account {
    private static BigDecimal currency = new BigDecimal(1);

    private boolean inUSD = false;
    private final BigDecimal[] USDdollars = {
            new BigDecimal(Double.toString(20)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.25)),
            new BigDecimal(Double.toString(.10)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    private final BigDecimal[] SWDdollars = {
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
        this.balance = new BigDecimal(Double.toString(balance)); // initalize in us dollars
    }

    /** These are the basic getter methods */
    public BigDecimal getBalance() {
        return balance;
    }
    private void updateBalance(BigDecimal amount){
        balance = balance.subtract(amount);
    }
    public int getAccountNum() {
        return accountNum;
    }


    /** The Setters and getters for currency */
    public static void setCurrency(double newCurrency) {
        Account.currency = new BigDecimal(Double.toString(newCurrency));
    }

    public static BigDecimal getCurrency() {
        BigDecimal c = currency.setScale(2, BigDecimal.ROUND_HALF_EVEN); // This rounds bigDecimal by 2 and rounds up.
        return c;
    }


    /** These are the exchangeFromSWD methods */
    public BigDecimal getExchangeFromSWD(BigDecimal amount){
        amount = amount.divide(currency, RoundingMode.HALF_UP);
        return amount;
    }
    public BigDecimal getExchangeFromSWD(double amount){
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
        amountBigD = amountBigD.divide(currency, RoundingMode.HALF_UP);
        return amountBigD;
    }


    /** These are the exchangeToSWD methods
     * The one that takes the double is best for when the user just wants to see exchange rate
     * the other is best when doing the withdraw method.*/
    public BigDecimal getExchangeToSWD(BigDecimal amount){
        amount = amount.multiply(currency);
        return amount;
    }
    public BigDecimal getExchangeToSWD(double amount){ // This balance has nothing to do with my acutal balance var
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
        amountBigD = amountBigD.multiply(currency);
        return amountBigD;
    }



    public String verifyWithdraw(BigDecimal amount){
        if(amount.compareTo(balance) == 1){ // if you try taking more than you have
            return "Error: not enough money";
        }
        return "";
    }





    /* this is the withdraw method in SWD */
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
        inUSD = false;

        /* 6. We can now call the withdraw method */
        output = getWithdraw(amountBigD);

        return output;
    }


    private String getWithdraw(BigDecimal amountBigD){
        String hold = "";

        BigDecimal[] dollars;

        if(inUSD == false){
            dollars = SWDdollars.clone();
        }else {
            dollars = USDdollars.clone();
        }

        int i = 0;
        while(amountBigD.compareTo(new BigDecimal(Double.toString(0))) > 0){
            int countBill = 0;
            while(amountBigD.compareTo(dollars[i]) >= 0){
                countBill++;
                amountBigD = amountBigD.subtract(dollars[i]);
            }

            amountBigD = amountBigD.setScale(2, BigDecimal.ROUND_HALF_EVEN); // This rounds bigDecimal by 2 and rounds up.

            hold = hold + countBill + " - " + dollars[i] + " SWD Bill, \n";
            i++;
        }

        return hold;
    }




}
