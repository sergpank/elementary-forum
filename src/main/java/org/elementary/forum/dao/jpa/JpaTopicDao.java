package org.elementary.forum.dao.jpa;

import org.elementary.forum.entities.Topic;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaTopicDao
{
  public Topic getById(long id)
  {
    EntityManager em = JpaUtil.getEntityManager();

    Topic topic = em.find(Topic.class, id);

    em.close();

    return topic;
  }

  public void save(Topic t)
  {
    EntityManager em = JpaUtil.getEntityManager();

    em.getTransaction().begin();
    em.persist(t);
    em.getTransaction().commit();

    em.close();
  }

  public List<Topic> loadAll()
  {
    EntityManager em = JpaUtil.getEntityManager();

    List<Topic> topics = em
        .createQuery("from Topic", Topic.class)
        .getResultList();

    return topics;
  }
}
