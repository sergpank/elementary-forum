<%@ page import="org.elementary.forum.dao.jpa.JpaTopicDao" %>
<%@ page import="org.elementary.forum.entities.Topic" %>
<%@ page import="java.util.List"%>

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>


<%
    List<Topic> topics = new JpaTopicDao().loadAll();

    for (Topic t : topics)
    {
        out.println("<h1>");
        out.println(String.format("<a href=\"posts?tid=%s\">%d :: %s (%s)</a>",
                t.getId(), t.getId(), t.getTitle(), t.getDateCreated()));
        out.println("</h1>");
    }
%>

</body>
</html>