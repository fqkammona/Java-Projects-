import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Exchange extends Currencies{

    ArrayList<CurrenciesList> currencies = new ArrayList<CurrenciesList>(){
        {
            add(new CurrenciesList("USD", USDdollars, USDcurrency));
            add(new CurrenciesList("CAD", CADdollars, CADcurrency));
            add(new CurrenciesList("SWD", SWDdollars, SWDcurrency));
        }
    };

    /* Default for myCurrentCurrency is USD */
    public CurrenciesList myCurrentCurrency = new CurrenciesList("USD", USDdollars, USDcurrency);


    /** Returns the exchangeRate for the currentCurrency */
    public BigDecimal getExchangeRate() {
        return myCurrentCurrency.getExchangeRate();
    }

    public String setMyCurrentCurrency(String name){
        for(CurrenciesList holdCurrency : currencies){
            if(holdCurrency.getName().equals(name)){
                myCurrentCurrency = holdCurrency;
                return "";
            }
        }
        return "Error Currency not found";
    }

    public String printCurrencyList(){
        String list = "";
        for(CurrenciesList holdCurrency : currencies){
            list = list + holdCurrency.getName() + ": " + holdCurrency.getExchangeRate() + "\n";
        }
        return list;
    }


    /** This method finds the current Currency and then updates it */
    public String upDateCurrency(BigDecimal newCurrency, String name){
        String hold = findCurrentCurrency(name);

        if(hold.equals("")){
            updateExchangeRate(newCurrency);
            return name + " currency has been updated";
        }

        return hold;
    }

    private void updateExchangeRate(BigDecimal newCurrency){
        myCurrentCurrency.upDateExchangeRate(newCurrency);
    }


    /** A function that finds ...*/
    public String findCurrentCurrency(String name){

        for(CurrenciesList holdCurrency : currencies){
            if(holdCurrency.getName().equals(name)){
                myCurrentCurrency = holdCurrency;
                return "";
            }
        }
        return "Error Currency not found";
    }

    public String getCurrencyName() {
        return myCurrentCurrency.getName();
    } /** GET RID OF THE WORD PUBLIC */




    /** These are the exchangeFromSWD methods */
//    public BigDecimal getExchangeFromSWD(BigDecimal amount){
//        amount = amount.divide(exchangeRate, RoundingMode.HALF_UP);
//        return amount;
//    }
//    public static BigDecimal getExchangeFromSWD(double amount){
//        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
//       // amountBigD = amountBigD.divide(exchangeRate, RoundingMode.HALF_UP);
//        return amountBigD;
//    }
//
//
//    public static BigDecimal getIdeaToSWD(double amount, Currencies Name){
//        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
//        //amountBigD = amountBigD.divide(Currencies.SWD, RoundingMode.HALF_UP);
//        return amountBigD;
//    }
//
//
//    /** These are the exchangeToSWD methods
//     * The one that takes the double is best for when the user just wants to see exchange rate
//     * the other is best when doing the withdrawal method.*/
//    public BigDecimal getExchangeToSWD(BigDecimal amount){
//        amount = amount.multiply(exchangeRate);
//        amount = amount.setScale(1, RoundingMode.HALF_UP);
//        return amount;
//    }
//    public BigDecimal getExchangeToSWD(double amount){ // This balance has nothing to do with my acutal balance var
//        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));
//        amountBigD = amountBigD.multiply(exchangeRate);
//        amountBigD = amountBigD.setScale(1, RoundingMode.HALF_UP);
//        return amountBigD;
//    }
//
//    public String getWithdraw(BigDecimal amountBigD, BigDecimal[] dollars){
//        String hold = "";
//
//        int i = 0;
//        while(amountBigD.compareTo(new BigDecimal(Double.toString(0))) > 0){
//            int countBill = 0;
//            while(amountBigD.compareTo(dollars[i]) >= 0){
//                countBill++;
//                amountBigD = amountBigD.subtract(dollars[i]);
//            }
//
//            amountBigD = amountBigD.setScale(2, RoundingMode.HALF_UP); // This rounds bigDecimal by 2 and rounds up.
//
//            hold = hold + countBill + " - " + dollars[i] + " SWD Bill, \n";
//            i++;
//        }
//        return hold;
//    }
}
