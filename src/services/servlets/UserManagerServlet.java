package services.servlets;

import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.ws.server.sei.EndpointResponseMessageBuilder;
import services.javabean.Account;
import services.userDao.AccountProxy;
import services.utils.HeadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Account account = findDb(accountName);
        String type = request.getParameter("type");

        HeadUtils.printRequestParams(request);
        if ("login".equals(type)) {
            if (canLogin(account, accountName, pwd)) {
                write("登录成功", response);
            } else {
                write("登录失败,数据库中没有该账户信息", response);
            }
        } else if ("register".equals(type)) {
            if (canLogin(account, accountName, pwd)) {
                write("你已经是本站会员，请到登录页登录", response);
            } else {
                if (insertAccount(accountName, pwd)) {
                    write("注册成功", response);
                } else {
                    write("注册失败", response);
                }
            }
        }

    }

    private Account findDb(String accountName) {
        AccountProxy accountProxy = new AccountProxy();
        Account account = accountProxy.findByAccountName(accountName);
        return account;
    }

    private boolean insertAccount(String account, String pwd) {
        AccountProxy accountProxy = new AccountProxy();
        Account data = new Account();
        data.setPwd(pwd);
        data.setAccountName(account);
        data.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        return accountProxy.doCreate(data);
    }


    private boolean canLogin(Account account, String accountName, String pwd) {
        if (account == null) {
            return false;
        } else if (accountSuc(account, accountName) && pwdSuc(account, pwd)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean accountSuc(Account account, String accountName) {
        if (account.getAccountName() == null || !account.getAccountName().equals(accountName)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean pwdSuc(Account account, String pwd) {
        if (account.getPwd() == null || !account.getPwd().equals(pwd)) {
            return false;
        } else {
            return true;
        }
    }


    private void write(String msg, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write(msg);
        printWriter.flush();
        printWriter.close();
    }
}
