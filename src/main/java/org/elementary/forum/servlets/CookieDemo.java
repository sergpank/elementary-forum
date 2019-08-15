package org.elementary.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet
{

    public static final String USER_ID = "user_id";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss:SSS");
        Cookie sessionId = new Cookie("session_id", request.getRemoteAddr() + "_" + formatter.format(new Date()));
        Cookie language = new Cookie("language", request.getLocale().toString());

        if (findUserIdCookie(request.getCookies()) == null)
        {
            Cookie userId = new Cookie(USER_ID, "Vasya_" + formatter.format(new Date()));
            userId.setMaxAge(5);
            response.addCookie(userId);
        }

        response.addCookie(sessionId);
        response.addCookie(language);

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String title = "Cookies Demo";
        String docType = "<!DOCTYPE html>";

        Cookie[] cookies = request.getCookies();

        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");

        if (cookies != null)
        {
            writer.println("Cookies");
            for (Cookie cookie : cookies)
            {
                writer.println("<hr/>");
                writer.println("Name: " + cookie.getName());
                writer.println("<br/>");
                writer.println("Value: " + cookie.getValue());
                writer.println("<br/>");
                writer.println("Max age: " + cookie.getMaxAge());
                writer.println("<hr/>");
            }
        }
        else
        {
            writer.println("No cookies");
        }
        writer.println("</body></html>");
    }

    private Cookie findUserIdCookie(Cookie[] cookies)
    {
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals(USER_ID))
                {
                    return cookie;
                }
            }
        }
        return null;
    }
}
