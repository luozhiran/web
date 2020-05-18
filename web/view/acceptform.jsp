<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册信息</title>
</head>
<body>

<%=request.getParameter("account")%><br/>
<%=request.getParameter("pwd")%><br/>
<%=request.getParameter("confirmPwd")%><br/>
<%=request.getParameter("rule")%><br/>
<%=session.getId()%>

</body>
</html>
