
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要遍历显示，要导入jstl的包,使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>您已成功退出</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="panel-heading text-center">
            <h2>您已成功退出图书馆图书预约系统</h2>
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!--用来展示预约控件-->
                <span class="glyphicon"  >
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books/list.do">重新登录</a>
                </span>

            </h2>
        </div>
    </div>
</div>
</body>
</html>


