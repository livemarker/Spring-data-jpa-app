<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<br />
<br>Введите логин
<br>
<div class="form-floating">
    <input type="text" class="form-control"  placeholder="login">
</div>

<br>Введите имя
<br>
<div class="form-floating">
    <input type="text" class="form-control"  placeholder="иван">
</div>

<br>Введите фамилию
<br>
<div class="form-floating">
    <input type="text" class="form-control"  placeholder="Иванов">
</div>

<br>Введите адресс
<br>
<div class="form-floating">
    <input type="text" class="form-control"  placeholder="ул.горького д.5">
</div>

<br>Введите телефон
<br>
<div class="form-floating">
    <input type="text" class="form-control" id="floatingInput" placeholder="+795865458">
</div>

<br>
<a href="/account" >зарегистрироваться(не активна)</a>

<a href="/main">назад</a>
</body>
</html>
