<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 06.09.2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
${oneProduct.id} ${oneProduct.name} ${oneProduct.price}
<br>
<form method="POST" action="/product?id=${oneProduct.id}" id="newPost" name ="newPost" enctype="multipart/form-data">
    <input type="submit" id="btnAddPost" name="btnAddPost" value="добавить в корзину" onclick="" style="cursor:pointer"/>
</form>
<br>
<br>
<br>
<br>
<br>
<br>
Комментарии:

<c:forEach var="comment" items="${comments}">
    <br>
    ${comment.text}
    <br>
</c:forEach>

<br>
<br>
<br>
<a href="/shop"> назад </a>
</body>
</html>