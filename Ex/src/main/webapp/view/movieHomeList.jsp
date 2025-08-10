<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/08
  Time: 22:34
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
        <th>Title</th>
        <th>Director</th>
        <th>ReleaseDate</th>
        <th>Genre</th>
        <th>Poster</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movieList}" var="movie" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td>${movie.poster}</td>
            <td><a href="<%=request.getContextPath()%>/parseMovie&id">Edit</a></td>
            <td><a href="<%=request.getContextPath()%>/deleteMovie&id">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/addMovie">Add Movie</a>
</body>
</html>
