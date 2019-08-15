package org.elementary.forum.servlets;

import org.elementary.forum.dao.TopicDao;
import org.elementary.forum.entites.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TopicsServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setAttribute("a",1111);
    request.setAttribute("b", 222);

    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/topics.jsp");
    requestDispatcher.forward(request, response);


  }
}
