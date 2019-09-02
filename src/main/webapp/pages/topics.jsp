<%@ page import="org.elementary.forum.dao.TopicDao" %>
<%@ page import="org.elementary.forum.entites.Topic" %>
<%@ page import="java.util.List"%>

<%@ page contentType="text/html; charset=UTF-8" %>


<html>
<head>
    <meta charset="UTF-8">
</head>
<body>


<%
    List<Topic> topics = new TopicDao().loadAll();
%>

<c:foreach items="${topics}" var="topic">
<h1>
    <a href="/posts&tid=${topic.getId()}">${topic.getId()} :: ${topic.getName()}</a>
</h1>
</c:foreach>

</body>
</html>