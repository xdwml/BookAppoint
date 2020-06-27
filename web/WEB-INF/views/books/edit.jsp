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
    <title>编辑图书</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="panel-heading text-center">
            <h2>编辑图书</h2>
        </div>

<%--表单提交，form表单命名要和对应@RequestMapping一致--%>
    <form id="itemsFrom" action="${pageContext.request.contextPath}/books/update.do" method="post">
    <%--带边框的表格--%>
        <table border="1">
            <%--五行二列--%>
            <tr>
                <td>图书名称</td>
                <td><input type="text" name="name" value="${book.name}"></td>
                <td><input type="hidden" name="id" value="${book.bookId}"></td>

            </tr>
            <tr>
                <td>图书描述</td>
                <td><input type="text" name="introd" value="${book.introd}"></td>
            </tr>
            <tr>
                <td>库存</td>
                <td><textarea name="number"> ${book.number}</textarea></td>
            </tr>

            <tr><%--占用两列colspan="2"--%>
                <td colspan="2">
                    <input type="submit" value="更新">
                </td>

            </tr>
        </table>
    </form>
</body>
</html>
