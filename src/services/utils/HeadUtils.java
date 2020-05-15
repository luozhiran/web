package services.utils;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

public class HeadUtils {

    public static void printRequestHeaders(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaderNames();
        String terminal = request.getHeader("terminal");
        System.out.println("\n\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if ("mobile".equals(terminal)) {
            System.out.println("|  取得手机请求头信息:");
            System.out.println("|");
        } else {
            System.out.println("|  取得浏览器请求头信息:");
            System.out.println("|  ");

        }
        String headerKey = "";
        while (headers.hasMoreElements()) {
            headerKey = headers.nextElement();
            System.out.println("|  " + headerKey + ": " + request.getHeader(headerKey));
        }
        System.out.println("|_____________________________________________________________");

    }


    public static void printRequestParams(HttpServletRequest request) {

        Enumeration<String> headers = request.getParameterNames();

        System.out.println("\n\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("|  取得表单数据:");
        String headerKey = "";

        while (headers.hasMoreElements()) {
            headerKey = headers.nextElement();
            System.out.println("|  " + headerKey + ": " + request.getParameter(headerKey));
        }

        System.out.println("|_____________________________________________________________");

    }
}
