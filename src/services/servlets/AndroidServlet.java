package services.servlets;

import com.alibaba.fastjson.JSON;
import services.javabean.User;
import services.utils.HeadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
        User user = buildUser();
        String userJson = JSON.toJSONString(user);
        printWriter.write(userJson);
        printWriter.flush();
        printWriter.close();
    }

    private User buildUser() {
        User user = new User();
        user.setName("fastjson");
        user.setPwd("pwd123456");
        user.setAge(11);
        user.setBirthDay("2020-9-13");
        return user;
    }
}
