<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   КОРЗИНА
</head>
<body>
<table border="1px">
    <c:forEach var="cart" items="${carts}">
        <tr>
            <td width="30%" valign="top">
                <a href="">${cart.name} ${cart.price}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<form method="post" action="/cart" id="newPost" name ="newPost" enctype="multipart/form-data">
    <input type="submit" id="btnAddPost" name="btnAddPost" value="очистить корзину" onclick="" style="cursor:pointer"/>
</form>
<br>
<br>
<a href="/account">назад</a>

</body>
</html>
