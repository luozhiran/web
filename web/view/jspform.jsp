<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/18
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link href="../css/jspform.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="div1">
    <h1>请注册你的账户</h1>
</div>

<div class="div2">



    <form action="../view/acceptform.jsp" method="post">

        <span>账号：</span><input type="text" name="account"/><br/>
        <span> 密码：</span><input type="text" name="pwd"/><br/>
        <span>确定密码：</span><input type="password" name="confirmPwd"/><br/>
        <span>本站协议：</span><input type="checkbox" name="rule"/><br/>
        <input type="submit" name="提交">
    </form>
</div>

</body>
</html>
