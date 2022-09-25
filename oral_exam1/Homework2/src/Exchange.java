import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Exchange extends Currencies{
    public static BigDecimal currency = new BigDecimal(Double.toString(1.00));

    ArrayList<CurrenciesList> currenciesList = new ArrayList<CurrenciesList>(){
        {
            add(new CurrenciesList("USD", USDdollars, USDcurrency));
            add(new CurrenciesList("CAD", CADdollars, CADcurrency));
            add(new CurrenciesList("SWD", SWDdollars, SWDcurrency));
        }
    };


    public CurrenciesList currentCurrencie;


    public void findCurrentCurrency(String name){

    }

    public String getCurrencyName() {
        return currentCurrencie.getName();
    } /** GET RID OF THE WORD PUBLIC */

 //   public static final BigDecimal currency;
    public static void setCurrency(double newCurrency) {
        Exchange.currency = new BigDecimal(Double.toString(newCurrency));
    }

//    public Exchange(BigDecimal currency){
//        this.currency = currency;
//    }
    public static BigDecimal getCurrency() {
        return currency;
    }

    /** These are the exchangeFromSWD methods */
    public BigDecimal getExchangeFromSWD(BigDecimal amount){
        amount = amount.divide(currency, RoundingMode.HALF_UP);
        return amount;
    }
    public static BigDecimal getExchangeFromSWD(double amount){
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
        amountBigD = amountBigD.divide(currency, RoundingMode.HALF_UP);
        return amountBigD;
    }


    public static BigDecimal getIdeaToSWD(double amount, Currencies Name){
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
        //amountBigD = amountBigD.divide(Currencies.SWD, RoundingMode.HALF_UP);
        return amountBigD;
    }


    /** These are the exchangeToSWD methods
     * The one that takes the double is best for when the user just wants to see exchange rate
     * the other is best when doing the withdrawal method.*/
    public BigDecimal getExchangeToSWD(BigDecimal amount){
        amount = amount.multiply(currency);
        amount = amount.setScale(1, RoundingMode.HALF_UP);
        return amount;
    }
    public BigDecimal getExchangeToSWD(double amount){ // This balance has nothing to do with my acutal balance var
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
        amountBigD = amountBigD.multiply(currency);
        amountBigD = amountBigD.setScale(1, RoundingMode.HALF_UP);
        return amountBigD;
    }

    public String getWithdraw(BigDecimal amountBigD, BigDecimal[] dollars){
        String hold = "";

        int i = 0;
        while(amountBigD.compareTo(new BigDecimal(Double.toString(0))) > 0){
            int countBill = 0;
            while(amountBigD.compareTo(dollars[i]) >= 0){
                countBill++;
                amountBigD = amountBigD.subtract(dollars[i]);
            }

            amountBigD = amountBigD.setScale(2, RoundingMode.HALF_UP); // This rounds bigDecimal by 2 and rounds up.

            hold = hold + countBill + " - " + dollars[i] + " SWD Bill, \n";
            i++;
        }
        return hold;
    }
}
