<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>

<%@ page import="org.elementary.forum.entites.Post"%>
<%@ page import="org.elementary.forum.entites.Topic"%>
<%@ page import="org.elementary.forum.dao.TopicDao"%>
<%@ page import="org.elementary.forum.dao.PostDao"%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>


<html>
<head>
    <meta charset="UTF-8">
</head>
<body>


<%
TopicDao topicDao = new TopicDao();
PostDao postDao = new PostDao();

Topic topic = topicDao.getById(1);

//List<Post> posts = new ArrayList<>();
//posts = topic.getPosts();

String text = request.getParameter("postText");
Post post = new Post ();
post.setAuthorId(1);
post.setTopic(topic);
post.setDateCreated(new Date());
post.setText(text);
//posts.add(post);

//topicDao.save(topic);

postDao.save(post);

%>

</body>
</html>