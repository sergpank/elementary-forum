package org.elementary.forum.servlets;

import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entites.Topic;
import org.elementary.forum.entites.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserTopicServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    UserDao userDao=new UserDao();
    TopicDao topicDao=new TopicDao();

    List<User> users=userDao.loadAll();
    User selectedUser=null;
    List<Topic> topicList=null;

    String authorId=req.getParameter("authorId");
    if(authorId!=null)
    {
      long key=Long.parseLong(authorId);
      selectedUser=userDao.getById(key);
    }
    else
    {
      selectedUser=(users!=null && users.size()>0)? users.get(0) : null;
    }

    if(selectedUser!=null)
    {
      topicList=topicDao.getByAuthorId(selectedUser.getId());
    }

    req.setAttribute("users", users);
    req.setAttribute("topicList", topicList);
    req.setAttribute("currentUser", selectedUser);

    getServletContext()
        .getRequestDispatcher("/user-topic.jsp")
        .forward(req, resp);
  }
}
