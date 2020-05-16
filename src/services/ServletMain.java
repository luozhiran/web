package services;


import services.utils.Format;
import services.utils.HeadUtils;
import services.utils.SqlMag;
import services.utils.WebManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 * Tomcat下面总是会把GET/POST过来的reqest.parameters以ISO8859-1来解码
 */
//@WebServlet("/") 保留web.xml中的配置
public class ServletMain extends HttpServlet {

    private String message;
    private SqlMag sqlMag;

    @Override
    public void init() throws ServletException {
        super.init();

        message = "Hello word!!!!!!!!!!!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message = "Hello POST " + WebManager.plugCounter(getServletContext());
        HeadUtils.printRequestHeaders(request);
        HeadUtils.printRequestParams(request);
        sql();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/default.jsp");
        requestDispatcher.forward(request, response);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(message);
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message = "Hello GET " + WebManager.plugCounter(getServletContext());
        HeadUtils.printRequestHeaders(request);
        HeadUtils.printRequestParams(request);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(message);
        printWriter.flush();
        printWriter.close();
    }


    private void sql() {
        sqlMag = new SqlMag();
        sqlMag.connected().createStatement();
        String sql = "SELECT id,name,pwd,createtime FROM account";
        try {
            ResultSet rs = sqlMag.stmt.executeQuery(sql);
            Format.instance().start(4*30);
            Format.instance().drawLine("id","name","pwd","createtime");
            Format.instance().end();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("pwd");
                String createtime = rs.getString("createtime");
                Format.instance().drawLine(String.valueOf(id),name,pwd.trim(),createtime);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("|___________________________查询失败    _______________________________|");
        } finally {
            sqlMag.closeStmt().closeConnection();
            Format.instance().end();
        }

    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
