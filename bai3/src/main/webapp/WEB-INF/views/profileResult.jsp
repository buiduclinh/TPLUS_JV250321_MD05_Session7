<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/09
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile Result</title>
</head>
<body>
<h2>Profile Information</h2>
<p><strong>Username:</strong> ${username}</p>

<c:if test="${not empty avatarPath}">
    <p><strong>Avatar:</strong></p>
    <img src="${pageContext.request.contextPath}${avatarPath}" width="200"/>
</c:if>

</body>
</html>
