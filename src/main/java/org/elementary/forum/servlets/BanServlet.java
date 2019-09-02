package org.elementary.forum.servlets;

import org.elementary.forum.dao.BanDao;
import org.elementary.forum.entites.Ban;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BanServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    PrintWriter writer = resp.getWriter();
    BanDao banDao = new BanDao();
    Ban ban = new Ban(req.getParameter("login"), req.getParameter("reason"));
    banDao.save(ban);
    writer.println("DONE");
  }
}
