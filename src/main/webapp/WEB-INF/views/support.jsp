<%--
  Created by IntelliJ IDEA.
  User: маркер
  Date: 03.09.2021
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    ТЕХ. ПОДДЕРЖКА
</head>
<body>
<table border="1px">
    <c:forEach var="support" items="${supports}">
        <tr>
            <td width="30%" valign="top">
                    ${support.id} | ${support.login} | ${support.text} | ${support.topic} | ${support.status}
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="/supportAdd">добавить обращение</a>
<br>
<br>
<a href="/account">назад</a>

</body>
</html>