<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <style>
    .orderpage-table{
      margin: 30px 0 30px 40px;
      text-align: center;
    }
    tr {
      height: 40px;
    }

    .orderpage-colomn1{
      width: 150px;
    }

    .orderpage-colomn2{
      width: 100px;
    }
    .orderpage-colomn3 {
      width: 170px;
    }

    .orderpage-colomn4 {
      width: 200px;
    }
    .title{
      margin: 0 0 0 40px;
      font-size: 20px;
    }

    .orderpage-input{
      margin: 3px 0 0 0;
    }
    .orderpage-input2{
      margin: 0 0 0 40px;
    }
    a{
      color: mediumblue;
    }

  </style>
</head>
<body>
  <span class="title">Список заказов</span>

<table border="1" class="orderpage-table">
  <tr>
    <th class="orderpage-colomn1">Товар</th>
    <th class="orderpage-colomn2">Цена</th>
    <th class="orderpage-colomn3">Покупатель</th>
    <th class="orderpage-colomn3">Действия</th>
  </tr>
  <c:forEach items="${orderList}" var="order">
    <tr><td class="orderpage-colomn1">${order.good}</td>
      <td class="orderpage-colomn2">${order.price}</td>
      <td class="orderpage-colomn4">${order.user.firstName} ${order.user.lastName}</td>
      <td class="orderpage-colomn3">
        <a href="/final_project/orderPage/updateOrder/${order.id}" class="orderpage-input">Изменить</a>

        <a href="/final_project/orderPage/deleteOrder/${order.id}" class="orderpage-input">Удалить</a>
      </td>
    </tr>
  </c:forEach>
</table>
<div>
    <a href="/final_project/back" class="orderpage-input2">Назад</a>
</div>
</body>
</html>

