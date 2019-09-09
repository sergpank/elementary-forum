<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
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
                <tr>
                    <td>${topic.id}</td>
                    <td>${topic.title}</td>
                    <td>${topic.dateCreated}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>