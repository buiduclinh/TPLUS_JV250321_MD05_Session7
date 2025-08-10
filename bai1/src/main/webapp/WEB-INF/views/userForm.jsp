<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/10
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Nhập thông tin cá nhân</title>
</head>
<body>
<h2>Form Nhập Thông Tin Cá Nhân</h2>
<form:form action="submitForm" method="post" modelAttribute="user">
    <p>Tên: <form:input path="name" /></p>
    <p>Tuổi: <form:input path="age" /></p>
    <p>Địa chỉ: <form:input path="address" /></p>
    <p><input type="submit" value="Gửi" /></p>
</form:form>
</body>
</html>
