package pl.emdzej.exchangecalc;

import java.math.BigDecimal;

public enum ExchangeType {
    EURPLN("eur", "zł", new BigDecimal("4.3")),
    PLNEUR("zł", "eur", new BigDecimal("0.23"));

    private String baseCurrency;
    private String targetCurrencyl;
    private BigDecimal excageRate;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrencyl() {
        return targetCurrencyl;
    }

    public BigDecimal getExcageRate() {
        return excageRate;
    }

    ExchangeType(String baseCurrency, String targetCurrencyl, BigDecimal excageRate) {
        this.baseCurrency = baseCurrency;
        this.targetCurrencyl = targetCurrencyl;
        this.excageRate = excageRate;
    }
}
