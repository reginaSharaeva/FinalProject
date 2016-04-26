<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AddUser</title>
  <style>
    .error {
      color: red;
    }
    .new-user-page-input{
      margin: 0 0 0 40px;
    }
    .title{
      margin: 0 0 0 40px;
      font-size: 20px;
      font-weight: bold;
    }
    .new-user-page-field{
      height: 25px;
    }
    .new-user-page-submit{
      height: 25px;
      width: 80px;
    }
    a{
      margin: 0 0 0 40px;
      color: mediumblue;
    }
  </style>
</head>
<body>
<span class="title">Добавление пользователя: </span>
<br/><br/>
<a href="/cancelUser">Отмена</a>
<br/><br/>
<form:form method="post" commandName="userForm" cssClass="new-user-page-input">
  Имя: <form:errors path="firstName" cssClass="error"/><br />
  <form:input path="firstName" cssClass="new-user-page-field"/><br /><br />
  <br /><br />
  Фамилия: <form:errors path="lastName" cssClass="error"/><br />
  <form:input path="lastName" cssClass="new-user-page-field"/><br /><br />
  <br /><br />
  Возраст: <form:errors path="age" cssClass="error"/><br />
  <form:input path="age" cssClass="new-user-page-field"/><br /><br />
  <br /><br />
  Логин: <form:errors path="login" cssClass="error"/><br />
  <form:input path="login" cssClass="new-user-page-field"/><br /><br />
  <br /><br />
  Пароль: <form:errors path="password" cssClass="error"/><br />
  <form:password path="password" cssClass="new-user-page-field"/><br /><br />
  <br /><br />
  Подтверждение пароля: <form:errors path="confirmPassword" cssClass="error"/><br />
  <form:password path="confirmPassword" cssClass="new-user-page-field"/><br /><br />
  <input type="submit" value="Сохранить" class="new-user-page-submit">
</form:form>

</body>

</html>
