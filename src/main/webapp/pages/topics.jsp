<%@ page import="org.elementary.forum.entities.Topic" %>
<%@ page import="org.elementary.forum.dao.jpa.JpaTopicDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">

    <style>
        table {
            border-collapse: collapse;
        }

        table, td, th {
            border: 1px solid black;
        }
    </style>

</head>

<body>

<%--<%--%>
<%--    List<Topic> topics = new JpaTopicDao().loadAll();--%>

<%--    for (Topic t : topics)--%>
<%--    {--%>
<%--        out.println("<h1>");--%>
<%--        out.println(String.format("<a href=\"posts?tid=%s\">%d :: %s (%s)</a>",--%>
<%--                t.getId(), t.getId(), t.getTitle(), t.getDateCreated()));--%>
<%--        out.println("</h1>");--%>
<%--    }--%>
<%--%>--%>

<c:if test="${not empty topics}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Date Created</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${topics}" var="topic">
                <c:url value="/posts" var="topicURL">
                    <c:param name="tid" value="${topic.id}"/>
                </c:url>
                <tr>
                    <td>${topic.id}</td>
                    <td><a href="${topicURL}">${topic.title}</a></td>
                    <td>${topic.dateCreated}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>