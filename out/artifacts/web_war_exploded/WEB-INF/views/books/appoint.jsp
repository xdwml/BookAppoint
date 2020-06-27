<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>预约图书列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>您已预约的图书列表</h2>
        </div>
		<div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr> 
                    <th>预定学号</th>
                    <th>预约时间</th>
                    <th>图书ID</th> 
                    <%--<th>图书名称</th>
                    <th>图书简介</th> --%>
                    <th>预约数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${appointList}" var="sk">
                    <tr>
                    	<td>${sk.studentId}</td> 
                        <td>${sk.appointTime}</td>
                        <td>${sk.bookId}</td>
                        <td>1</td> 
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>
    </div>
</div>
</body>
</html>