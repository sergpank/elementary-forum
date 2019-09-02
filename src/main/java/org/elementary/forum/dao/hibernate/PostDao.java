package org.elementary.forum.dao.hibernate;

import org.elementary.forum.entities.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PostDao
{
  public Post getById(long id)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    Post post = session.get(Post.class, id);
    session.close();

    return post;
  }

  public Post save(Post post)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    // SAVE HERE
    session.save(post);

    session.getTransaction().commit();
    session.close();

    return post;
  }

  public List<Post> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    List<Post> posts = session.createQuery("from Post").list();

    session.close();

    return posts;
  }
}
