import java.math.BigDecimal;

public abstract class Currencies {
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
}
