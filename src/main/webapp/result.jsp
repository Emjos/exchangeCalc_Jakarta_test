<%@ page import="pl.emdzej.exchangecalc.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="pl.emdzej.exchangecalc.ExchangeType" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kalkulator walut</title>
</head>
<body>

<%
    ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
    BigDecimal base = exchangeResult.getBase();
    BigDecimal result = exchangeResult.getResult();
    ExchangeType exchangeType = exchangeResult.getExchangeType();
    String baseCurrency = exchangeType.getBaseCurrency();
    String targetCurrency = exchangeType.getTargetCurrencyl();

%>

<h2>
    <%=String.format("%s%s to %s%s", base.toString(), baseCurrency, result.toString(), targetCurrency)%>

</h2>
</body>
</html>
