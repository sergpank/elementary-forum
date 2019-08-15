<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

	<%
	List<Post> posts = (List<Post>)request.getAttribute("posts");
	if(posts == null){
	%>
		<p>This user has no posts.</p>
	<%
	}
	else{
		for(Post post : posts){
	%>
			<div class="panel panel-default">
				<div class="panel-heading"><h4><a href="/feed/<%= post.getAuthorId() %>"><%= post.getAuthorId() %></a></h4></div>
				<div class="panel-body"><%= post.getText() %></div>
				<div class="panel-footer">at <%= post.getDateCreated().toString() %></div>

			</div>
	<%
		}
	}
	%>
</div>

</body>
</html>