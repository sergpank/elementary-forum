package org.elementary.forum.dao;

import org.elementary.forum.entites.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao
{
  public User getById(long id)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    User user = session.get(User.class, id);
    session.close();

    return user;
  }
  public List<User> getByLogin(String login)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    javax.persistence.criteria.CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<User> root = cq.from(User.class);
    Query query = session.createQuery(cq);

    List<User> users = query.getResultList() ;
    session.close();

    return users;
  }

  public User save(User user)
  {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    session.beginTransaction();

    // SAVE HERE
    session.saveOrUpdate(user);

    session.getTransaction().commit();
    session.close();

    return user;
  }

  public List<User> loadAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();

    Criteria criteria = session.createCriteria(User.class);
    List users = criteria.list();
//    List users = session.createQuery("from User").list();

    session.close();

    return users;
  }
}
