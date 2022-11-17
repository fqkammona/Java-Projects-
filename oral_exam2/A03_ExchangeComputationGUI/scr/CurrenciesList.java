import java.math.BigDecimal;

public class CurrenciesList {
    public String name; // This is final because you should always have the same number
    public BigDecimal[] dollars;
    public String[] billNames;
    public BigDecimal exchangeRate;

    public CurrenciesList(String name, BigDecimal[] dollars, BigDecimal exchangeRate, String[] billNames) {
        this.name = name;
        this.dollars = dollars;
        this.exchangeRate = exchangeRate;
        this.billNames = billNames;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getExchangeRate(){
        return exchangeRate;
    }

    public  void upDateExchangeRate(BigDecimal exchangeRate){
       this.exchangeRate = exchangeRate;
    }

    public BigDecimal[] getDollars(){ return dollars; }

    public String[] getBillNames(){ return billNames; }
}
