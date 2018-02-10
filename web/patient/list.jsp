<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>患者信息列表</title>
</head>
<body>
    <table border=1>
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>性别</th>
            <th>生日</th>
            <th>电话</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td><c:out value="${item.id}" /></td>
                <td><c:out value="${item.name}" /></td>
                <td><c:out value="${item.sex}" /></td>
                <td><c:out value="${item.birthday}" /></td>
                <td><c:out value="${item.phone}" /></td>
                <td><c:out value="${item.createtime}" /></td>
                <td><c:out value="${item.updatetime}" /></td>
                <td><a href="PatientController?action=edit&id=<c:out value="${item.id}"/>">修改</a></td>
                <td><a href="PatientController?action=delete&id=<c:out value="${item.id}"/>">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="PatientController?action=insert">添加患者</a></p>
</body>
</html>
