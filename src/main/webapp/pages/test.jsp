<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>TEST</title>
</head>
<body>
<h1>Hello ${userName} (${userAge})</h1>

<c:if test="${userAge >= '30'}">
    <h1>Welcome old friend!</h1>
</c:if>

<c:choose>
    <c:when test="${userAge >= 30}">
        <h1>Happy to see you again!</h1>
    </c:when>
    <c:otherwise>
        <h1>You are too young. Good buy!</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
