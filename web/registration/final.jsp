<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>诊断</title>
</head>
<body>
    <form method="POST" action='RegistrationController' name="frmAddExam">
        编号 : <input type="text" readonly="readonly" name="id" value="<c:out value="${item.id}" />" /> <br />
        类型: <input type="text" readonly="readonly" name="status" value="诊断" /><br />
        病人编号 : <input type="text" readonly="readonly" name="patientId" value="<c:out value="${item.patientId}" />" /> <br />
        科室编号 : <input type="text" readonly="readonly" name="departmentId" value="<c:out value="${item.departmentId}" />" /><br />
        检查编号 : <input type="text" readonly="readonly" name="examinationId" value="<c:out value="${item.examinationId}" />" /><br />
        诊断编号 : <input type="text" name="diagnosisId" value="<c:out value="${item.diagnosisId}" />" /><br />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
