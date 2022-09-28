import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Exchange extends Currencies{

    ArrayList<CurrenciesList> currencies = new ArrayList<CurrenciesList>(){
        {
            add(new CurrenciesList("USD", USDdollars, USDcurrency, USDbillNames));
            add(new CurrenciesList("CAD", CADdollars, CADcurrency, USDbillNames)); // not correct
            add(new CurrenciesList("SWD", SWDdollars, SWDcurrency, SWDbillNames));
            add(new CurrenciesList("POUND", SWDdollars, POUNDcurrency, USDbillNames)); // not correct
        }
    };

    /* Default for myCurrentCurrency is USD */
    public CurrenciesList myCurrentCurrency = new CurrenciesList("USD", USDdollars, USDcurrency, USDbillNames);

    public CurrenciesList localCurrency = new CurrenciesList("USD", USDdollars, USDcurrency, USDbillNames);

    public String setLocalCurrency(String name){
        String output = setMyCurrentCurrency(name);

        if(output.equals("")){ localCurrency = myCurrentCurrency;}
        return output;
    }
    /** Returns the exchangeRate for the currentCurrency */
    public BigDecimal getExchangeRate() {
        return myCurrentCurrency.getExchangeRate();
    }

    /** A function that finds ...*/
    public String setMyCurrentCurrency(String name){
        for(CurrenciesList holdCurrency : currencies){
            if(holdCurrency.getName().equals(name)){
                myCurrentCurrency = holdCurrency;
                return "";
            }
        }
        return "Error: Currency not found";
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
        String hold = setMyCurrentCurrency(name);

        if(hold.equals("")){
            updateExchangeRate(newCurrency);
            return name + " currency has been updated";
        }

        return hold;
    }

    private void updateExchangeRate(BigDecimal newCurrency){
        myCurrentCurrency.upDateExchangeRate(newCurrency);
    }


    public String getCurrencyName() {
        return myCurrentCurrency.getName();
    } /** GET RID OF THE WORD PUBLIC */

// From Name1 to Name2
    public BigDecimal exchangeCurrency(String currencyName1, String currencyName2, double amount1){

        // We are already in USD and now need to convert
        if(currencyName1.equals("USD")){ return convertFromUSD(currencyName2, new BigDecimal(Double.toString(amount1))); }
        else if(currencyName2.equals("USD")) {
            return convertToUSD(currencyName1, new BigDecimal(Double.toString(amount1)));
        }
        else {
           BigDecimal amount = convertToUSD(currencyName1, new BigDecimal(Double.toString(amount1)));
           return convertFromUSD(currencyName2, amount);
        }

    }

    // We are in USD and now need to the exchange
    private BigDecimal convertFromUSD(String currencyName, BigDecimal amount){

        if(setMyCurrentCurrency(currencyName).equals("")) {
            amount = amount.multiply(myCurrentCurrency.getExchangeRate());
        }
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
    private BigDecimal convertToUSD(String currencyName, BigDecimal amount){

        if(setMyCurrentCurrency(currencyName).equals("")) {
            amount = amount.divide(myCurrentCurrency.getExchangeRate(), 2, RoundingMode.CEILING);
        }
        return amount;
    }

    public String getWithdraw(BigDecimal amountBigD){
        String hold = "";

        BigDecimal[] dollars = myCurrentCurrency.getDollars();
        String[] typeOfBill = myCurrentCurrency.getBillNames();
        int i = 0;
        while(amountBigD.compareTo(new BigDecimal(Double.toString(0))) > 0){
            int countBill = 0;

            while(amountBigD.compareTo(dollars[i]) >= 0){
                countBill++;
                amountBigD = amountBigD.subtract(dollars[i]);
            }

            amountBigD = amountBigD.setScale(2, RoundingMode.HALF_UP); // This rounds bigDecimal by 2 and rounds up.


            if(countBill == 1){ hold = hold + countBill + " - "
                     + " " + typeOfBill[i] + "\n";}
            if(countBill > 1){ hold = hold + countBill + " - "
                    + " " + typeOfBill[i] + "s\n";}

            i++;
        }
        return hold;
    }
}
