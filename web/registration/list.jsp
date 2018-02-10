<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>就诊信息列表</title>
</head>
<body>
    <table border=1>
        <thead>
        <tr>
            <th>编号</th>
            <th>病人编号</th>
            <th>科室编号</th>
            <th>检查编号</th>
            <th>诊断编号</th>
            <th>类型</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th colspan=3>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td><c:out value="${item.id}" /></td>
                <td><c:out value="${item.patientId}" /></td>
                <td><c:out value="${item.departmentId}" /></td>
                <td><c:out value="${item.examinationId}" /></td>
                <td><c:out value="${item.diagnosisId}" /></td>
                <td><c:out value="${item.status}" /></td>
                <td><c:out value="${item.createtime}" /></td>
                <td><c:out value="${item.updatetime}" /></td>
                <td><a href="RegistrationController?action=edit&id=<c:out value="${item.id}"/>">检查</a></td>
                <td><a href="RegistrationController?action=final&id=<c:out value="${item.id}"/>">诊断</a></td>
                <td><a href="RegistrationController?action=delete&id=<c:out value="${item.id}"/>">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="RegistrationController?action=add">挂号</a></p>
</body>
</html>
