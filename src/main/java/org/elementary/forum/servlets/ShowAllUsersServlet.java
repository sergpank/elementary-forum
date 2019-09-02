package org.elementary.forum.servlets;

import org.elementary.forum.dao.hibernate.UserDao;
import org.elementary.forum.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowAllUsersServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    PrintWriter writer = resp.getWriter();
    writer.println("<h1>Users</h1>");
    UserDao userDao = new UserDao();
    List<User> userList = userDao.loadAll();
    for(User u : userList)
    {
      writer.println("<br>" + u);
    }
  }
}
