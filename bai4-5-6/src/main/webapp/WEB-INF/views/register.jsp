<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form Đăng Ký</title>
</head>
<body>
<h2>Đăng Ký</h2>

<form:form method="post" modelAttribute="userForm">
    <div>
        <label>Tên:</label>
        <form:input path="username" />
        <form:errors path="username" cssClass="error"/>
    </div>
    <div>
        <label>Email:</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error"/>
    </div>
    <div>
        <label>Mật khẩu:</label>
        <form:password path="password" />
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label>Số điện thoại:</label>
        <form:input path="phone" />
        <form:errors path="phone" cssClass="error"/>
    </div>
    <div>
        <button type="submit">Đăng ký</button>
    </div>
</form:form>

</body>
</html>