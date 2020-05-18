<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/18
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<jsp:useBean id="register" class="services.javabean.RegisterBean" scope="request"/>
<body>

<form action="check.jsp" method="post">
    邮箱：<input type="text" name="email" value="<jsp:getProperty name="register" property="email"/>">
    <%=register.showErrorMsg("errorEmail")%><br/>
    用户名：<input type="text" name="name" value="<jsp:getProperty name="register" property="name"/>">
    <%=register.showErrorMsg("errorName")%><br/>
    密&nbsp;&nbsp;码:<input type="password" name="pwd" value="<jsp:getProperty name="register" property="pwd"/>"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
