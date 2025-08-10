<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/09
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h2>Upload Avatar</h2>

<form:form method="post" modelAttribute="userProfile"
           action="${pageContext.request.contextPath}/uploadAvatar"
           enctype="multipart/form-data">
    <label>Username:</label>
    <form:input path="username"/><br><br>

    <label>Avatar:</label>
    <form:input path="avatar" type="file"/><br><br>

    <button type="submit">Upload</button>
</form:form>

</body>
</html>
