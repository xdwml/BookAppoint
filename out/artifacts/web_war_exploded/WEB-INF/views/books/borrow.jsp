<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/15
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要遍历显示，要导入jstl的包,使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>借阅图书</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="panel-heading text-center">
            <h2>借阅图书</h2>
        </div>

<%--表单提交，form表单命名要和对应@RequestMapping一致--%>
    <form id="updateFrom" action="${pageContext.request.contextPath}/books/update.do" method="post">
        <table border="1">
            <tr>
                <td>用户ID</td>
                <td><input type="text" name="name" value="${appointment.studentId}"></td>
            </tr>
            <tr>
                <td>借阅时间</td>
                <td><input type="text" name="introd" value="${appointment.appointTime}"></td>
            </tr>
            <tr>
                <td>借阅图书ID</td>
                <td><input type="text" name="number" value="${appointment.bookId}"></td>
            </tr>
            <tr><%--占用两列colspan="2"--%>
                <td colspan="2">
                    <input type="submit" value="确认借阅">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
