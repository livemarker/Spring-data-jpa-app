<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 16:05
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
<br>
<table border="1px">
    <c:forEach var="shop" items="${category}">
        <tr>
            <td width="30%" valign="top">
                <a href="category?name=${shop.categories}">${shop.categories}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<a href="/account"> назад </a>

</body>
</html>