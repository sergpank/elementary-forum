package org.elementary.forum.servlets;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterDemo implements Filter
{
  private int cnt = 1;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException
  {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
  {
    HttpServletResponse http = (HttpServletResponse) servletResponse;
    http.addCookie(new Cookie("cookie-" + (cnt++), Long.toString(System.currentTimeMillis())));
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy()
  {

  }
}
