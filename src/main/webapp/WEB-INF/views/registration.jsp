<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>

<form method="POST" action="/registration" id="newPost" name ="newPost" enctype="multipart/form-data">
    <br>Введите логин
    <br>
    <label for="login"></label><input type="text" id="login" name="login" placeholder="login">

    <br>Введите пароль
    <br>
    <label for="password"></label><input type="text" id="password" name="password" value="" placeholder="password">

    <br>Введите имя
    <br>

    <label for="firstName"></label><input type="text" id="firstName" name="firstName" value="" placeholder="иван">


    <br>Введите фамилию
    <br>

    <label for="lastName"></label><input type="text" id="lastName" name="lastName" value="" placeholder="Иванов">


    <br>Введите адресс
    <br>

    <label for="address"></label><input type="text" id="address" name="address" value="" placeholder="ул.горького д.5">


    <br>Введите телефон
    <br>

    <label for="phoneNumber"></label><input type="text" id="phoneNumber" name="phoneNumber" value="" placeholder="+795865458">

    <br>
    <input type="submit" id="btnAddPost" name="btnAddPost" value="Зарегистрироваться" onclick="" style="cursor:pointer"/>
</form>
<a href="/main">назад</a>
</body>
</html>
