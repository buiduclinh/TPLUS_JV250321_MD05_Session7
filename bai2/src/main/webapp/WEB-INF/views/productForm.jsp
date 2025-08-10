<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
</head>
<body>
<h2>Form Thêm Sản Phẩm</h2>
<form:form action="addProduct" method="post" modelAttribute="product">
    <p>Tên sản phẩm: <form:input path="name" /></p>
    <p>Giá sản phẩm: <form:input path="price" /></p>
    <p>Mô tả sản phẩm: <form:textarea path="description" /></p>
    <p><input type="submit" value="Thêm sản phẩm" /></p>
</form:form>
</body>
</html>
