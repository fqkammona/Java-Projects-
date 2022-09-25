import java.math.BigDecimal;
import java.util.ArrayList;

public class Currencies {

    public final BigDecimal[] USDdollars = {
            new BigDecimal(Double.toString(20)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.25)),
            new BigDecimal(Double.toString(.10)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    public final BigDecimal[] SWDdollars = {
            new BigDecimal(Double.toString(25)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.20)),
            new BigDecimal(Double.toString(.08)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.01))
    };

    public final BigDecimal[] CADdollars = {
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

    public static BigDecimal CADcurrency = new BigDecimal(Double.toString(0.74));

    public static BigDecimal SWDcurrency = new BigDecimal(Double.toString(1.5));
    public static BigDecimal USDcurrency = new BigDecimal(Double.toString(1));

}
