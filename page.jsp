<%@ page import="java.util.List" %>
<%@ page import="org.elementary.forum.entites.User" %>
<%@ page import="org.elementary.forum.entites.Post" %>
<%@ page import="org.elementary.forum.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Сlass9-PC10
  Date: 12.08.2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UserDao userDao = new UserDao();
    List<User> users = userDao.loadAll();
    out.println("<select name=\"login\">");
    for (int i = 0; i < users.size(); i++) {
        out.println("<option value=" + users.get(i).getLogin() + ">" + users.get(i).getLogin() + "</option>");
    }
    out.println("</select><br>");
    out.println("<input type = \"submit\">");
%>
<%
    String login = request.getParameter("login");
    for (User u : users) {
        if (u.getLogin().equals(login)) {

    List<Post> posts = (List<Post>) request.getAttribute("posts");

    if (posts == null) {
        out.println("This user has no posts.");
}
    else {
    for (Post post : posts) {



String msg = String.format("User: %l  <br>" +
        "%s<br>" +
        " %d <br>", post.getAuthorId(), post.getText(),post.getDateCreated().toString());
out.println(msg);

        }
    }
%>


</body>
</html>
