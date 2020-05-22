package services.servlets;

import services.javabean.Account;
import services.userDao.AccountProxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class UserManagerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountName = request.getParameter("userName");
        String pwd = request.getParameter("password");
        AccountProxy accountProxy = new AccountProxy();
        Account account = accountProxy.findByAccountName(accountName);
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        response.setContentType("text/html; charset=UTF-8");
        if (account == null || account.getAccountName() == null || !account.getAccountName().equals(accountName)
                ||account.getPwd() == null|| !account.getPwd().equals(pwd)) {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("登录失败,数据库中没有该账户信息");
            printWriter.flush();
            printWriter.close();
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("登录成功");
            printWriter.flush();
            printWriter.close();
        }

    }
}
