package org.elementary.forum.servlets;

import org.elementary.forum.dao.BanDao;
import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entites.Ban;
import org.elementary.forum.entites.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ShowBannedUsersServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    PrintWriter writer = resp.getWriter();
    writer.println("<h1>BannedUsers</h1>");
    BanDao banDao = new BanDao();
    List<Ban> bannedList = banDao.loadAll();
    for(Ban b : bannedList)
    {
      writer.println("<br>" + b);
    }
  }
}
