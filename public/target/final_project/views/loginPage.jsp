<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
    <style>
        .error {
            color: red;
        }
        .loginpage-input{
            margin: 0 0 0 40px;
        }
        .title{
            margin: 0 0 0 40px;
            font-size: 20px;
            font-weight: bold;
        }
        .loginpage-field{
            height: 25px;
        }
        .loginpage-submit{
            height: 25px;
            width: 80px;
        }
    </style>
</head>
<body>
<span class="title">Вход в систему</span>
<br/>
<br/>
<form:form method="post" commandName="user" cssClass="loginpage-input">
    Логин: <form:errors path="login" cssClass="error"/><br />
    <form:input path="login" cssClass="loginpage-field"/><br />
    <br/>
    Пароль: <form:errors path="password" cssClass="error"/><br />
    <form:password path="password" cssClass="loginpage-field"/><br /><br />
    <br/>
    <input class="loginpage-submit" type="submit" value="Вход">
</form:form>
</body>

</html>