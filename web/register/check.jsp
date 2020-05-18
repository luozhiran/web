<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/18
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="register" class="services.javabean.RegisterBean" scope="request"/>
<jsp:setProperty name="register" property="*"/>
<head>
    <title>验证</title>
</head>
<body>

    <%
        if (register.isValidate()){
    %>
    <jsp:forward page="check.jsp"></jsp:forward>

    <%
        }else {

    %>

     <jsp:forward page="index.jsp"></jsp:forward>

    <%
        }
    %>
</body>
</html>
