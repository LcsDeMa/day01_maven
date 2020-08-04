<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
    <style>
        a{
            text-decoration: none;
        }

    </style>
</head>
<body>

<table border="1px" cellspacing="0px" cellpadding="10px" width="600px" height="200px">
    <tr>
        <td>ID</td>
        <td>账户</td>
        <td>密码</td>
    </tr>
    <c:forEach items="${pageBean.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    <%--分页工具条--%>
    <tr>
        <td colspan="3" align="center">
            第${pageBean.currentPage}/${pageBean.totalPage}页
            总记录数:${pageBean.totalSize}
            每页显示${pageBean.pageSize}条

            <c:if test="${pageBean.currentPage != 1}">
                <a href="${pageContext.request.contextPath}/user?methodName=selectUserListByPage&currentPage=1"> [首页] </a>
                <a href="${pageContext.request.contextPath}/user?methodName=selectUserListByPage&currentPage=${pageBean.currentPage-1}"> [上一页] </a>
            </c:if>

            <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/user?methodName=selectUserListByPage&currentPage=${pageBean.currentPage+1}"> [下一页] </a>
                <a href="${pageContext.request.contextPath}/user?methodName=selectUserListByPage&currentPage=${pageBean.totalPage}"> [尾页] </a>
            </c:if>

        </td>
    </tr>
</table>


</body>
</html>
