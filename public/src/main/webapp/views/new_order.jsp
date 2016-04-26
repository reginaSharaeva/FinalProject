<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AddOrder</title>
  <style>
    .error {
      color: red;
    }
    .new-order-page-input{
      margin: 0 0 0 40px;
    }
    .title{
      margin: 0 0 0 40px;
      font-size: 20px;
      font-weight: bold;
    }
    .new-order-page-field{
      height: 25px;
    }
    .new-order-page-select{
      height: 25px;
      width: 150px;
    }
    .new-order-page-submit{
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
<span class="title">Добавление заказа: </span>
<br/><br/>
<a href="/cancelUser">Отмена</a>
<br/><br/>
<form:form method="post" commandName="orderForm" cssClass="new-order-page-input">
  Название товара: <form:errors path="good" cssClass="error"/><br />
  <form:input path="good" cssClass="new-order-page-field"/><br /><br />
  <br />
  Цена: <form:errors path="price" cssClass="error"/><br />
  <form:input path="price" cssClass="new-order-page-field"/><br /><br />
  <br />
  Покупатель: <br/> <form:select path="userLogin" cssClass="new-order-page-select">
  <form:options items="${userList}" itemLabel="login" itemValue="login" />
  </form:select>
  <br/>
  <br/>
  <br/>
  <input type="submit" value="Сохранить" class="new-order-page-submit">
</form:form>

</body>

</html>


