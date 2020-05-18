<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/18
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="register" scope="request" class="services.javabean.RegisterBean"/>
<jsp:setProperty name="register" property="*"/>
<html>
<head>
    <title>登录成功</title>
</head>
<body>

    用户名：<jsp:getProperty name="register" property="name"/><br>
    邮箱：<jsp:getProperty name="register" property="email"/><br/>
    密码：<jsp:setProperty name="register" property="pwd"/>

</body>
</html>
