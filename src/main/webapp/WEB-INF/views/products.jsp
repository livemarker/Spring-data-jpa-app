<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    магазин
</head>
<body>
<br>
<br/>
<table border="1px">
    <c:forEach var="products" items="${products}">
        <br>
                <a href="">${products.id} ${products.name} ${products.price} </a>
        <br>
    </c:forEach>
    <br>
    <br>
    <br>
    <a href="/shop"> назад </a>
</table>
</body>
</html>