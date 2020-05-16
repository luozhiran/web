package services.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDispatcherUtil {

    /**
     * 跳转
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void dispatchRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        if ("luozhiran".equals(account)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/default.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.include(request, response);
        }
    }
}
