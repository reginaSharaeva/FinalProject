<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>UpdateOrder</title>
  <style>
    .error {
      color: red;
    }
    .update-order-page-input{
      margin: 0 0 0 40px;
    }
    .title{
      margin: 0 0 0 40px;
      font-size: 20px;
      font-weight: bold;
    }
    .update-order-page-field{
      height: 25px;
    }
    .update-order-page-select{
      height: 25px;
      width: 150px;
    }
    .update-order-page-submit{
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
<span class="title">Изменение заказа: </span>
<br/><br/>
<a href="/cancelOrder">Отмена</a>
<br/><br/>
<form:form method="post" commandName="orderForm" cssClass="update-order-page-input">
  Название товара: <form:errors path="good" cssClass="error"/><br />
  <form:input path="good" cssClass="update-order-page-field"/><br /><br />
  <br /><br />
  Цена: <form:errors path="price" cssClass="error"/><br />
  <form:input path="price" cssClass="update-order-page-field"/><br /><br />
  <br /><br />
  Покупатель: <form:select path="userLogin" cssClass="update-order-page-select">
  <form:options items="${userList}" itemLabel="login" itemValue="login" />
</form:select>
  <br/>
  <br/>
  <input type="submit" value="Изменить" class="update-order-page-submit">
</form:form>

</body>

</html>
