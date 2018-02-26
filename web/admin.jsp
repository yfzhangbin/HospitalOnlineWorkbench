<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>工作后台</title>
  </head>
  <body>
    <%--<jsp:forward page="/DepartmentController?action=list" />--%>
    <a href="/DepartmentController?action=list">科室管理</a>
    <a href="/DoctorController?action=list">医生管理</a>
    <a href="/PatientController?action=list">挂号管理</a>
    <%--<<a href="/RegistrationController?action=list">就诊管理</a>--%>
  </body>
</html>
