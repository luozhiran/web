<%--
  Created by IntelliJ IDEA.
  User: luozhiran
  Date: 2020/5/15
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息收集</title>
    <link href="../css/form.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="div1">
    <h1>注册你的账户</h1>
</div>
<form action="../hello" method="post">

    <div>
        <span>账号：</span><input type="text" name="account"/>
    </div>

    <div>
        <span>密码：</span><input type="password" name="pwd"><br/>
    </div>

    <div>
        <span>确定密码：</span><input type="password" name="confirmPwd"><br/>
    </div>

    <div class="div2">
        <input type="submit" name="提交">

    </div>

</form>
</body>
</html>
