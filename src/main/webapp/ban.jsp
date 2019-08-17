<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ban</title>
</head>
<body>
    <%= "<h1>Welcome to BAN panel !</h1>" %>
    <form action="ShowAllUsers" method="get">
    <button name="action" value="Users">ShowAllUsers</button>
    </form>

    <form action="ShowBannedUsers" method="get">
    <button name="action" value="BannedUsers">ShowBannedUsers</button>
    </form>

    <form action="Ban" method="get">
    <input type="text" name="login">
    <input type="text" name="reason">
    <button name="action" value="Ban">Ban</button>
    </form>

    <form action="Unlock" method="get">
    <input type="text" name="login">
    <button name="action" value="Unlock">Unlock</button>
    </form>

</body>
</html>