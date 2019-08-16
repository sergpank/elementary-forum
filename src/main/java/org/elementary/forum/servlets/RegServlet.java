package org.elementary.forum.servlets;

import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entites.Post;
import org.elementary.forum.entites.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();

        if (!userDao.thereIs(name))
        {
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            user.setRegistrationDate(new Date());
            userDao.save(user);
            PrintWriter out = resp.getWriter();
            out.println("Registration successful");
        }else {
            RequestDispatcher view = req.getRequestDispatcher("reregistration.jsp");
            PrintWriter out = resp.getWriter();
            out.println("User with this login already exists!\n" +
                "Try again");
            view.forward(req, resp);
        }
    }
}
