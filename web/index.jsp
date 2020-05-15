<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/14
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>

  <%!
     private int initVar = 0;
     private int serviceVar = 0;
     private int destroyVar = 0;
  %>

  <%!
        public void jspInit(){
            initVar++;
            System.out.println("jspInit() : jsp被初始化了"+initVar+"次");
        }

        public void jspDestroy(){
            destroyVar++;
            System.out.println("jspDestroy(): jsp被销毁了"+destroyVar+"次");
        }
    %>
    <%
        serviceVar++;
        System.out.println("_jspService(): jsp共享应了"+serviceVar+"次请求");

        String content1 = "初始化次数"+initVar;
        String content2 = "想要客户端次数"+serviceVar;
        String content3 = "销毁次数: "+destroyVar;

     %>


    <h1>jsp初始化原理</h1>

    <p><%=content1%></p>
    <p><%=content2%></p>
    <p><%=content3 %></p>

  <p>
      <%
          out.println("Your IP address is "+request.getRemoteAddr());
      %>
  </p>
  </body>
</html>
