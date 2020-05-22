package services.servlets;

import com.alibaba.fastjson.JSON;
import services.javabean.Account;
import services.utils.HeadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AndroidServlet",urlPatterns = {"/android"})
public class AndroidServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }


    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        HeadUtils.printRequestHeaders(request);
        HeadUtils.printRequestParams(request);
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        Account user = buildUser();
        String userJson = JSON.toJSONString(user);
        printWriter.write(userJson);
        printWriter.flush();
        printWriter.close();
    }

    private Account buildUser() {
        Account user = new Account();
        user.setAccountName("fastjson");
        user.setPwd("pwd123456");
        user.setId(11);
        user.setCreateTime("2020-9-13");
        return user;
    }
}
