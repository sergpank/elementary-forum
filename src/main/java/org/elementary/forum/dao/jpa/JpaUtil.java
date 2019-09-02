package org.elementary.forum.dao.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil
{
  private static final Logger log = LogManager.getLogger(JpaUtil.class);

  private static EntityManagerFactory entityManagerFactory;

  public static EntityManager getEntityManager()
  {
    if (entityManagerFactory == null)
    {
      log.info("Initializing entity manager factory ...");
      entityManagerFactory = Persistence.createEntityManagerFactory("elementary.forum");
    }
    return entityManagerFactory.createEntityManager();
  }
}
