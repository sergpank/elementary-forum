package org.elementary.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo extends HttpServlet
{
    @Override public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String message = "";

        String sessionId = session.getId();
        Date sessionCreationDate = new Date(session.getCreationTime());
        Date lastSessionAccess = new Date(session.getLastAccessedTime());
        String userId = "userId";

        if (session.isNew())
        {
            message = "Welcome to this page";
        }
        else
        {
            message = "Glad to see You again";
        }

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String title = "Session Tracking Demo";
        String docType = "<!DOCTYPE html>";

        writer.println(docType + "<html>" +
                               "<head>" +
                               "<title>" + title +
                               "</title>" +
                               "</head>" +
                               "<body>" +
                               "<h1>" + message + "</h1>" +
                               "<h1>Session Details</h1>" +
                               "Session ID:" + sessionId +
                               "<br/>" +
                               "Created: " + sessionCreationDate +
                               "<br/>" +
                               "Last Accessed Date: " + lastSessionAccess +
                               "<br/>" +
                               "User ID: " + userId);

        Cookie[] cookies = request.getCookies();

        if (cookies != null)
        {
            writer.println("<h2>Cookies:</h2>");
            for (Cookie cookie : cookies)
            {
                writer.println("<hr/>");
                writer.println("Name: " + cookie.getName());
                writer.println("<br/>");
                writer.println("Value: " + cookie.getValue());
                writer.println("<hr/>");
            }
        }
        else
        {
            writer.println("No cookies");
        }

        writer.println("</body></html>");

        writer.close();
    }
}
