<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/09
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <label for="">categoryName</label>
    <form:input path="categoryName"/>
    <br>
    <label for="">description</label>
    <form:input path="description"/>
    <br>
    <form:errors path="description" cssClass="error"/>
    <br>
    <button type="submit">submit</button>
</form:form>
</body>
</html>
