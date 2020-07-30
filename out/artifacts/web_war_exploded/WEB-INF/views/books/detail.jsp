<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要遍历显示，要导入jstl的包,使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书详情</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="panel-heading text-center">
            <h2>图书详情</h2>
        </div>
        <div class="col-md-12 column">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>图书名称</th>
                    <th>图书介绍</th>
                    <th>馆藏数量</th>
                    <th>预约数量</th>
                    <%--<th>借阅图书</th>--%>
                </tr>
                </thead>
                <tbody>
                    <tr class="success" >
                        <td>${book.bookId}</td>
                        <td>${book.name}</td>
                        <td>${book.introd}</td>
                        <td>${book.number}</td>
                        <td>1</td>
                        <%--<td>
                            <a href="${pageContext.request.contextPath}/books/borrow.do?id=${book.bookId}">借阅</a>
                        </td>--%>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!--用来展示预约控件-->
                <span class="glyphicon"  >
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books/list.do">返回上一级</a>
                </span> <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->
                <span class="glyphicon" id="appoint-box" >
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books/borrow.do?id=${book.bookId}">预约</a>
                </span> <!--在js里面调用这个id还可以动态显示一些其他东西，例如动态时间等（需要插件）-->

                <span class="glyphicon">
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books/appoint.do" target="_blank">查看已预约书籍</a>
                </span>
            </h2>           <!--如何获取该页面弹出层输入的学生ID， 传给上面的url-->
        </div>
    </div>
</div>
</body>
</html>
