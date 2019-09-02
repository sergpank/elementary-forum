package org.elementary.forum.servlets;

import org.elementary.forum.bo.PostBO;
import org.elementary.forum.dao.hibernate.TopicDao;
import org.elementary.forum.entities.Post;
import org.elementary.forum.entities.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreatePostServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    RequestDispatcher view = req.getRequestDispatcher("/pages/createPost.jsp");

    TopicDao topicDao = new TopicDao();
    PostBO postBO = new PostBO();

    Topic topic = topicDao.getById(1);

    //List<Post> posts = new ArrayList<>();
    //posts = topic.getPosts();

    String text = req.getParameter("postText");
    Post post = new Post();
    post.setAuthorId(1);
    post.setTopic(topic);
    post.setDateCreated(new Date());
    post.setText(text);
    //posts.add(post);

    //topicDao.save(topic);

    postBO.save(post);


    view.forward(req, resp);
  }
}
