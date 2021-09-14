<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 14.09.2021
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    ТЕХ. ПОДДЕРЖКА
</head>
<body>
<form method="POST" action="/supportAdd" id="newTicket" name="newTicket" enctype="multipart/form-data">
    <br>Введите Тему
    <br>
    <label for="title"></label><input type="text" id="title" name="title" placeholder="Тема1">

    <br>Введите Текст
    <br>
    <label for="text"></label><textarea type="text" id="text" name="text" placeholder="ТекстТекстТекст"></textarea>

    <input type="submit" id="btnAddPost" name="btnAddPost" value="добавить обращение" onclick=""
           style="cursor:pointer"/>
</form>
<br>
<br>
<a href="/account">назад</a>

</body>
</html>
