package services;

import services.utils.HeadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Tomcat下面总是会把GET/POST过来的reqest.parameters以ISO8859-1来解码
 */
public class ServletDemo extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        super.init();
        message = "Hello word!!!!!!!!!!!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message = "Hello POST";
        HeadUtils.printRequestHeaders(request);
        HeadUtils.printRequestParams(request);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(message);
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message = "Hello GET";
        HeadUtils.printRequestHeaders(request);
        HeadUtils.printRequestParams(request);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(message);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
