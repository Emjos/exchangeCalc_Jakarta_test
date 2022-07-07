package pl.emdzej.exchangecalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCalculator {

    static  ExchangeResult exchangeResult(BigDecimal base,ExchangeType exchangeType)
    {
        BigDecimal exchangeRate = exchangeType.getExcageRate();
        BigDecimal reslut = base.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
        return new ExchangeResult(base,reslut,exchangeType);
    }
}
