package org.elementary.forum.dao;

import org.elementary.forum.entites.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TopicDao
{
  public Topic getById(long id)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    Topic topic = session.get(Topic.class, id);
    session.close();

    return topic;
  }

  public Topic save(Topic topic)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    Transaction transaction = session.getTransaction();
    transaction.begin();

    // SAVE HERE
    session.save(topic);

    transaction.commit();

    session.close();

    return topic;
  }

  public List<Topic> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();

    session.close();

    return topics;
  }
}
