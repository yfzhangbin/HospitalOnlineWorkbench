<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>添加医生信息</title>
</head>
<body>
    <form method="POST" action='DoctorController' name="frmAddDep">
        编号 : <input type="text" readonly="readonly" name="id" value="<c:out value="${item.id}" />" /> <br />
        名称 : <input type="text" name="name" value="<c:out value="${item.name}" />" /> <br />
        性别 : <input type="text" name="sex" value="<c:out value="${item.sex}" />" /> (男、女)<br />
        生日 : <input type="text" name="birthday" value="<c:out value="${item.birthday}" />" /> (格式: yyyy-MM-dd 例如: 2018-01-25)<br />
        电话 : <input type="text" name="phone" value="<c:out value="${item.phone}" />" /> <br />
        级别 : <input type="text" name="level" value="<c:out value="${item.level}" />" /> (实习、正式、副主任、主任、教授)<br />
        部门编号 : <input type="text" name="departmentId" value="<c:out value="${item.departmentId}" />" /> <br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
