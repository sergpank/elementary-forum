<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@page import="org.elementary.forum.entites.*" %>
<%@page import="java.util.List" %>
<%
	List<User> users=(List<User>)request.getAttribute("users");
	User currentUser=(User)request.getAttribute("currentUser");
	List<Topic> topicList=(List<Topic>)request.getAttribute("topicList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>User's topics</title>
	<style>
		.container{
			margin: 50px auto;
			max-width: 600px;
		}
		hr{
			margin: 20px 0;
		}
		button{
			margin-left: 10px;
		}
	</style>
</head>
<body>
	<div class="container">
		<%
			if(currentUser!=null)
			{
		%>
			<form action="" method="GET">
				<label>
					Выберите пользователя: 
					<select name="authorId">
						<%
							for(User user : users)
							{
								out.print("<option value='"+user.getId()+"'");
								if(user.getId()==currentUser.getId())
								{
									out.print("selected");
								}
								out.print(">"+user.getLogin()+"</option>");
							}
						%>
					</select>
				</label>
				<button type="submit">выбрать</button>
			</form>
			<hr>
			<h3>Пользователь: <%=currentUser.getLogin()%></h3>
			<h4>Список тем:</h4>
			<%
				if(topicList==null || topicList.size()==0)
				{
			%>
					<p>Темы отсутствуют</p>
			<%
				}
				else
				{
			%>
					<ul>
						<%
							for(Topic t : topicList)
							{
						%>
								<li><%=t.getTitle()%>; Дата создания: <%=t.getDateCreated()%></li>
						<%
							}
						%>
					</ul>
			<%
				}
			%>
		<%
			}
			else
			{
		%>
				<h2>Данные отсутствуют</h2>
		<%
			}
		%>
	</div>
</body>
</html>