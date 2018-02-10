<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>xx医院-线上工作平台</title>
  </head>
  <body>
    <%--<jsp:forward page="/DepartmentController?action=list" />--%>
    <a href="/DepartmentController?action=list">科室管理</a>
    <a href="/DoctorController?action=list">医生管理</a>
    <a href="/PatientController?action=list">患者管理</a>
    <a href="/RegistrationController?action=list">就诊管理</a>
  </body>
</html>
