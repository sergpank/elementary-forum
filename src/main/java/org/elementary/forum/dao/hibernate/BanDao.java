package org.elementary.forum.dao.hibernate;

import org.elementary.forum.entities.Ban;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BanDao
{
  public Ban save(Ban ban)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    // SAVE HERE
    session.saveOrUpdate(ban);

    session.getTransaction().commit();
    session.close();

    return ban;
  }


  public Ban delete(Ban ban)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.delete(ban);
    session.getTransaction().commit();
    session.close();
    return ban;
  }

  public List<Ban> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Ban> banned = session.createQuery("from Ban").list();

    session.close();

    return banned;
  }
}
