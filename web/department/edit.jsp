<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>添加科室信息</title>
</head>
<body>
    <form method="POST" action='DepartmentController' name="frmAddDep">
        科室编号 : <input type="text" readonly="readonly" name="id" value="<c:out value="${dep.id}" />" /> <br />
        科室名称 : <input type="text" name="name" value="<c:out value="${dep.name}" />" /> <br />
        科室地址 : <input type="text" name="address" value="<c:out value="${dep.address}" />" /> <br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
