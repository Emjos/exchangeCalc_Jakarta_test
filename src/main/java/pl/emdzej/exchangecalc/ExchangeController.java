package pl.emdzej.exchangecalc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/convert ")
public class ExchangeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueString = req.getParameter("value");
        BigDecimal value = new BigDecimal(valueString);
        String exchangeString = req.getParameter("exchange");
        ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
        ExchangeResult exchangeResult = ExchangeCalculator.exchangeResult(value,exchangeType);
        req.setAttribute("result", exchangeResult);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
