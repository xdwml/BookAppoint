<%--
  Created by IntelliJ IDEA.
  User: 001
  Date: 2020/6/5
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请您登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <style>
        .row-center{
            text-align:center;
            margin-top: 120px;
        }
        .col-center {
            display:inline-block;
            float:none;
            text-align:left;
        }
    </style>
</head>
<body>
<div class="container" >
    <div class="row-center">
        <div class="col-center">
            <div style="background-color: darkseagreen;padding: 28px">
                <form id="loginFrom" action="${pageContext.request.contextPath}/login.do" method="post">
                    <div style="height: 80px;">
                        <h3 style="text-align: center;color: darkolivegreen; font-size: 35px;">登录中心</h3>
                    </div>
                    <label>学号</label>
                    <div  class="form-group">
                    <input type="text" name="username" class="form-control uname" placeholder="请输入您的学号"/>
                    </div>
                    <label>密码</label>
                    <div  class="form-group">
                        <input type="text" name="password" class="form-control pword" placeholder="请输入您的密码"/>
                    </div>
                    <%
                        String cookieName="user";
                        Cookie cookie=new Cookie(cookieName,"username");
                        cookie.setMaxAge(60);//存活期1分钟
                        response.addCookie(cookie);
                    %>
                    <div class="submit">
                        <button type="submit" class="btn btn-lg  btn-login btn-block" style="background-color: darkturquoise;">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    <%--<form id="loginFrom" action="${pageContext.request.contextPath}/login.do" method="post">
        <input type="text" name="username"><br>
        <input type="text" name="password"><br>
        <input type="submit" value="登录"><br>
    </form>--%>
</body>
</html>
