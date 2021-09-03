<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    example login=Никита
</head>
<body>
<br>
Login= ${user.login}
<br>
Имя= ${user.firstName}
<br>
Фамилия= ${user.lastName}
<br>
Адрес= ${user.address}
<br>
Телефон= ${user.phoneNumber}
<br>
<br>
<a href="/account">назад</a>

</body>
</html>