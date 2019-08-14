<%@ page import="java.util.List" %>
<%@ page import="org.elementary.forum.dao.UserDao" %>
<%@ page import="org.elementary.forum.entites.User" %>
<%@ page import="org.elementary.forum.dao.TopicDao" %>
<%@ page import="org.elementary.forum.entites.Topic" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form method="GET" action = "/new_topic">
  <label>
    Enter the title :
    <input type="text" name="topicTitle">
  </label><br>

  Sign in with login from the box :

    <%
      UserDao userDao = new UserDao();
      List<User> users = userDao.loadAll();
      out.println("<select name=\"login\">");
      for (int i = 0; i<users.size(); i++)
      {
        out.println("<option value="+ users.get(i).getLogin()+ ">" + users.get(i).getLogin() + "</option>");
      }
      out.println("</select><br>");
      out.println("<input type = \"submit\">");
    %>
    <%
      String login = request.getParameter("login");
      User user = new User();
      for(User u : users)
      {
        if(u.getLogin().equals(login))
        {
          user = u;
        }
      }
      TopicDao topicDao = new TopicDao();
      Topic topic = new Topic();
      String title = request.getParameter("topicTitle");
      topic.setTitle(title);
      topic.setAuthor(user);
      topic.setDateCreated(new Date());
      topicDao.save(topic);
    %>
</form>
</body>
</html>