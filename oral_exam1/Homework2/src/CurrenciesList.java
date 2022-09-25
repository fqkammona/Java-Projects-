import java.math.BigDecimal;
import java.util.ArrayList;

public class CurrenciesList {
//    ArrayList<CurrenciesList> currencies = new ArrayList<CurrenciesList>(){
//        {
//            add(new CurrenciesList("USD", USDdollars, USDcurrency));
//            add(new CurrenciesList("CAD", CADdollars, CADcurrency));
//            add(new CurrenciesList("SWD", SWDdollars, SWDcurrency));
//        }
//    };
    public String name; // This is final because you should always have the same number
    public BigDecimal[] dollars;

    public BigDecimal exchangeRate;

    public CurrenciesList(String name, BigDecimal[] dollars, BigDecimal exchangeRate) {
        this.name = name;
        this.dollars = dollars;
        this.exchangeRate = exchangeRate;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getExchangeRate(){
        return exchangeRate;
    }

    public void upDateExchangeRate(BigDecimal exchangeRate){
        this.exchangeRate = exchangeRate;
    }
}
