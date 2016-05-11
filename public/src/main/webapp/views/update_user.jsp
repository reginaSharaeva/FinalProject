<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>UpdateUser</title>
  <style>
    .error {
      color: red;
    }
    .update-user-page-input{
      margin: 0 0 0 40px;
    }
    .title{
      margin: 0 0 0 40px;
      font-size: 20px;
      font-weight: bold;
    }
    .update-user-page-field{
      height: 25px;
    }
    .update-user-page-submit{
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
<span class="title">Изменение пользователя: </span>
<br/><br/>
<a href="/final_project/cancelUser">Отмена</a>
<br/><br/>
<form:form method="post" commandName="userForm" cssClass="update-user-page-input">
  Имя: <form:errors path="firstName" cssClass="error"/><br />
  <form:input path="firstName" cssClass="update-user-page-field"/><br /><br />
  <br /><br />
  Фамилия: <form:errors path="lastName" cssClass="error"/><br />
  <form:input path="lastName" cssClass="update-user-page-field"/><br /><br />
  <br /><br />
  Возраст: <form:errors path="age" cssClass="error"/><br />
  <form:input path="age" cssClass="update-user-page-field"/><br /><br />
  <br /><br />
  Пароль: <form:errors path="password" cssClass="error"/><br />
  <form:password path="password" cssClass="update-user-page-field"/><br /><br />
  Подтверждение пароля: <form:errors path="confirmPassword" cssClass="error"/><br />
  <form:password path="confirmPassword" cssClass="update-user-page-field"/><br /><br />
  <input type="submit" value="Изменить" class="update-user-page-submit">
</form:form>

</body>

</html>
