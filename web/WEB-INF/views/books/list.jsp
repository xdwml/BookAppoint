<%@ page import="edu.xidian.appoint.model.Student" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要遍历显示，要导入jstl的包,使用EL表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
        <form name="firstForm" action="${pageContext.request.contextPath}/books/search.do" method="post">
            <div class="panel-heading ">
                <table class="table table-bookName">
                    <thead>
                    <tr>
                        <th width="150" align="lift" colspan="3">请输入您要查询的图书名称：</th>
                        <th width="150" align="lift">
                            <input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索书名^o^" />
                        </th>
                        <th>
                            <input type="submit" id="tabSub" value="检索" />
                        </th>
                        <th>
                            <a href="${pageContext.request.contextPath}/books/appoint.do">我的借阅</a>
                        </th>
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
                        <th>欢迎您，<%=value%></th>
                        <%
                                        break;
                                    }
                                }
                            }
                            %>
                        <th>
                            <a href="${pageContext.request.contextPath}/books/exit.do">退出</a>
                        </th>
                    </tr>
                    </thead>
                </table>
            </div>
        </form>
        <div class="col-md-12 column">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>图书名称</th>
                    <th>馆藏数量</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${booksList}" var="books">
                    <tr class="success">
                        <td>${books.bookId}</td>
                        <td>${books.name}</td>
                        <td>${books.number}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/books/detail.do?id=${books.bookId}">详细</a><%--访问控制器中的方法--%>
                            &nbsp;<a href="${pageContext.request.contextPath}/books/borrow.do?id=${books.bookId}">借阅</a>
                            <%--管理员操作权限--%>
                            <%--&nbsp;<a href="${pageContext.request.contextPath}/books/delete.do?id=${books.bookId}">删除</a>&lt;%&ndash;访问控制器中的方法&ndash;%&gt;
                            &nbsp;<a href="${pageContext.request.contextPath}/books/edit.do?id=${books.bookId}">编辑</a>&lt;%&ndash;访问控制器中的方法&ndash;%&gt;--%>
                        </td>
                    </tr>
                </c:forEach><%--EL表达式--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
