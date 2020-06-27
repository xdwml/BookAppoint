<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要遍历显示，要导入jstl的包,使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
图书：<br>
<%--带边框的表格--%>
<table border="1">
    <%--三行五列--%>
    <tr>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>图书描述</td>
        <td>馆内图书</td>
        <td>图书操作</td>
    </tr>
    <c:forEach items="${booksList}" var="books">
    <tr>
        <td>${books.bookId}</td>
        <td>${books.name}</td>
        <td>${books.introd}</td>
        <td>${books.number}</td>
            <%--操作标签有两个，删除和修改--%>
        <td><%--nbsp为空格--%>
            <a href="${pageContext.request.contextPath}/books/delete.do?id=${books.bookId}">删除</a><%--访问控制器中的方法--%>
            &nbsp;<a href="${pageContext.request.contextPath}/books/edit.do?id=${books.bookId}">编辑</a><%--访问控制器中的方法--%>
        </td>

    </tr>
    </c:forEach><%--EL表达式--%>
</body>
</html>
