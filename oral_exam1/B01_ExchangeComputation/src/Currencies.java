import java.math.BigDecimal;

public abstract class Currencies {
    public static final BigDecimal[] USDdollars = {
            new BigDecimal(Double.toString(20)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.25)),
            new BigDecimal(Double.toString(.10)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    public static final BigDecimal[] SWDdollars = {
            new BigDecimal(Double.toString(25)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.20)),
            new BigDecimal(Double.toString(.08)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    public static final BigDecimal[] CADdollars = {
            new BigDecimal(Double.toString(20)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(2)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.25)),
            new BigDecimal(Double.toString(.10)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    public static final String[] USDbillNames = {
            "20 Dollar Bill",
            "10 Dollar Bill",
            "5 Dollar Bill",
            "1 Dollar Bill",
            "Quarter",
            "Dime",
            "Nickle",
            "Pennie"
    };

    public static final String[] SWDbillNames = {
            "25 SWD Bill",
            "10 SWD Bill",
            "5 SWD Bill",
            "1 SWD Bill",
            "20 cent SWD coin",
            "8 cent SWD coin",
            "5 cent SWD coin",
            "1 cent SWD coin"
    };

    public BigDecimal CADcurrency = new BigDecimal(Double.toString(1.37));

    public  BigDecimal SWDcurrency = new BigDecimal(Double.toString(1));
    public  BigDecimal USDcurrency = new BigDecimal(Double.toString(1));

    public  BigDecimal POUNDcurrency = new BigDecimal(Double.toString(0.93));



}
