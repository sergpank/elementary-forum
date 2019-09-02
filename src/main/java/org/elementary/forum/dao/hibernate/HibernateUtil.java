package org.elementary.forum.dao.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.elementary.forum.entities.Ban;
import org.elementary.forum.entities.Post;
import org.elementary.forum.entities.Topic;
import org.elementary.forum.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class HibernateUtil
{
  private static final Logger log = LogManager.getLogger(HibernateUtil.class);

  private static SessionFactory sessionFactory;

  private static EntityManagerFactory entityManagerFactory;

  public static SessionFactory getSessionFactory()
  {
    if(sessionFactory == null)
    {
      try
      {
        Configuration configuration = new Configuration().configure();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Topic.class);
        configuration.addAnnotatedClass(Ban.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());
      }
      catch (Exception e)
      {
        log.error("{}", e.getMessage(), e);
        throw new RuntimeException(e);
      }
    }
    return sessionFactory;
  }

//  public static EntityManagerFactory getEntityManagerFactory()
//  {
//    if (entityManagerFactory == null)
//    {
//
//    }
//  }
}
