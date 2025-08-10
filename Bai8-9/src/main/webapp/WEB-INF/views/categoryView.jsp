<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/09
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>Category Name</th>
        <th>Description</th>
        <th>Status</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${categoryList}" var="category" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td>${category.description}</td>
            <td>${category.status}</td>
            <td><a href="${pageContext.request.contextPath}/CategoryController/getCategory?id=${category.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/CategoryController/deleteCategory?id=${category.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/addCategory">add category</a>
</body>
</html>
