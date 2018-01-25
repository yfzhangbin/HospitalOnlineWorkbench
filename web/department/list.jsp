<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>科室信息列表</title>
</head>
<body>
    <table border=1>
        <thead>
        <tr>
            <th>科室编号</th>
            <th>科室名称</th>
            <th>科室地址</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${deps}" var="dep">
            <tr>
                <td><c:out value="${dep.id}" /></td>
                <td><c:out value="${dep.name}" /></td>
                <td><c:out value="${dep.address}" /></td>
                <td><c:out value="${dep.createtime}" /></td>
                <td><c:out value="${dep.updatetime}" /></td>
                <td><a href="DepartmentController?action=edit&id=<c:out value="${dep.id}"/>">修改</a></td>
                <td><a href="DepartmentController?action=delete&id=<c:out value="${dep.id}"/>">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="DepartmentController?action=insert">添加科室</a></p>
</body>
</html>
