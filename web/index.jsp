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
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/css_login.css">
</head>


<body>

<div class="dowebok limiter">


    <div class="container-login100" style="background-image: url('images/img-01.jpg');">

        <div class="wrap-login100 p-t-190 p-b-30">

            <form class="login100-form validate-form">

                <div class="login100-form-avatar">
                    <img src="images/avatar_img.jpg" alt="AVATAR"/>
                </div>


                <span class="login100-form-title p-t-20 p-b-45">HelloWeba</span>


                <!-- 用户名 -->
                <div class="wrap-input100 validate-input m-b-10" data-validate="请输入用户名">
                    <input class="input100" type="text" name="userName" placeholder="用户名" autocapitalize="off"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                        <i class="fa fa-user"></i>
                    </span>
                </div>


                <!-- 输入密码 -->
                <div class="wrap-input100 validate-input m-b-10" data-validate="请输入密码">
                    <input class="input100" type="text" name="password" placeholder="密码"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                        <i class="fa fa-lock"></i>
                    </span>
                </div>


                <!-- 登录按钮 -->
                <div class="container-login100-form-btn p-t-10">
                    <button class="login100-form-btn">登录</button>
                </div>

                <!-- 忘记密码 -->
                <div class="text-center w-full p-t-25 p-b-230">
                    <a href="https://www.baidu.com/" class="txt1" target="_blank">忘记密码</a>
                </div>

                <!--立即注册-->
                <div class="text-center w-full">
                    <a class="txt1" href="https://www.baidu.com/" target="_blank">
                        立即注册
                        <i class="fa fa-long-arrow-right"></i>
                    </a>

                </div>

            </form>

        </div>
    </div>

</div>

</body>


</html>
