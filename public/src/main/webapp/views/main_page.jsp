<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .mainpage-table{
            margin: 30px 0 30px 40px;
            text-align: center;
        }
        tr {
            height: 40px;
        }

        .mainpage-colomn1{
            width: 150px;
        }
        .mainpage-colomn2{
            width: 150px;
        }
        .mainpage-colomn3{
            width: 100px;
        }
        .mainpage-colomn4 {
            width: 170px;
        }
        .title{
            margin: 0 0 0 40px;
            font-size: 20px;
        }
        .mainpage-href{

            margin: 0 0 0 100px;
        }
        .mainpage-input{
            margin: 3px 0 0 0;
        }
        .mainpage-input2{
            margin: 0 0 0 615px;
        }
        a{
            color: mediumblue;
        }

    </style>
</head>
<body>

    <span class="title">Список пользователей:</span>

    <a href="/orderPage" class="mainpage-href">Список заказов</a>

    <a href="/newOrder" class="mainpage-href">Создать заказ</a>

<table border="1" class="mainpage-table">
    <tr>
        <th class="mainpage-colomn1">Фамилия</th>
        <th class="mainpage-colomn2">Имя</th>
        <th class="mainpage-colomn3">Возраст</th>
        <th class="mainpage-colomn2">Логин</th>
        <th class="mainpage-colomn4">Действия</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr><td class="mainpage-colomn1">${user.lastName}</td>
            <td class="mainpage-colomn2">${user.firstName}</td>
            <td class="mainpage-colomn3">${user.age}</td>
            <td class="mainpage-colomn2">${user.login}</td>
            <td class="mainpage-colomn4">
                <a href="/updateUser/${user.id}" class="mainpage-input">Изменить</a>
                <a href="/final_project/deleteUser/${user.id}" class="mainpage-input">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="/newUser" class="mainpage-input2">Создать пользователя</a>
</div>
</body>
</html>

