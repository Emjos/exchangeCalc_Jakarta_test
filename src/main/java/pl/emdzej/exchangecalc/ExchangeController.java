package pl.emdzej.exchangecalc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet("/convert")
public class ExchangeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validateParameters(request)) {
            successDispatch(request, response);
        } else {
            errorDispatch(request, response);
        }
    }

    private boolean validateParameters(HttpServletRequest request) {
        String exchangeParam = request.getParameter("exchange");
        if (exchangeParam == null || exchangeParam.equals("")) {
            request.setAttribute("message", "Set the Currency to exchange");
            return false;
        } else {
            ExchangeType[] exchangeTypes = ExchangeType.values();
            boolean invalidExchangeType = Arrays.stream(exchangeTypes)
                    .map(Enum::toString)
                    .noneMatch(exchangeType -> exchangeType.equals(exchangeParam));
            if (invalidExchangeType) {
                request.setAttribute("message", "unidentified currency: " + exchangeParam);
                return false;
            }
        }
        String value = request.getParameter("value");
        if (value == null || value.equals("")) {
            request.setAttribute("message", "Set Value");
            return false;
        } else if (!value.matches("-?\\d+(\\.\\d+)?")) {
            request.setAttribute("message", "Wrong VALUE");
        }
        return true;
    }

    private void successDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueString = request.getParameter("value");
        BigDecimal value = new BigDecimal(valueString);
        String exchangeString = request.getParameter("exchange");
        ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
        ExchangeResult exchangeResult = ExchangeCalculator.exchangeResult(value, exchangeType);
        request.setAttribute("result", exchangeResult);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");

        requestDispatcher.forward(request, response);
    }

    private void errorDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
}