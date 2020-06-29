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
            <%
                //1.获取所有Cookie
                Cookie[] cookies = request.getCookies();
                //2.遍历cookie数组
                if(cookies != null && cookies.length > 0){
                    for (Cookie cookie : cookies) {
                        //3.获取cookie的名称
                        String username = cookie.getName();
                        //4.判断是否存在
                        if("username".equals(username)){
                            //获取Cookie的value
                            System.out.println("接收到Cookie用户："+username);
                            String value = cookie.getValue();
                            System.out.println("接收到Cookie用户值："+value);
            %>
            <h2><%=value%>,您已预约的图书</h2>
            <%
                            break;
                        }
                    }
                }
            %>

        </div>
        <div class="col-md-12 column">
            <table class="table table-striped table-hover">
                <thead>
                <tr> 
                    <th>预约学号</th>
                    <th>图书ID</th>
                    <th>图书名称</th>
                    <th>预约时间</th>
                    <th>预约数量</th>
                    <th>还书管理</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${appointList}" var="sk">
                    <tr class="success">
                    	<td>${sk.studentId}</td>
                        <td>${sk.bookId}</td>
                        <td>${sk.book.name}</td>
                        <td>${sk.appointTime}</td>
                        <td>1</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/reply.do?id=${sk.bookId}" >还书</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>
        <div class="panel-body text-center">
            <h2 class="text-danger">
                <!--用来展示预约控件-->
                <span class="glyphicon"  >
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books/list.do">返回首页</a>
                </span>
            </h2>
        </div>
    </div>
</div>
</body>
</html>