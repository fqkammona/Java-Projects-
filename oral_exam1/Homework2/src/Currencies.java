import java.math.BigDecimal;
import java.util.ArrayList;

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

    public BigDecimal CADcurrency = new BigDecimal(Double.toString(0.74));

    public  BigDecimal SWDcurrency = new BigDecimal(Double.toString(1));
    public  BigDecimal USDcurrency = new BigDecimal(Double.toString(1));

    public  BigDecimal POUNDcurrency = new BigDecimal(Double.toString(0.93));



}
