package org.elementary.forum.dao.jpa;

import org.elementary.forum.entities.Post;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaPostDao
{
    public Post getById(long id)
    {
        EntityManager em = JpaUtil.getEntityManager();

        Post post = em.find(Post.class, id);

        em.close();

        return post;
    }

    public void save(Post p)
    {
        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();
    }

    public List<Post> loadAll(Long topicId)
    {
        EntityManager em = JpaUtil.getEntityManager();

        List<Post> posts = em
                .createQuery("from Post p where p.topic.id = :topic_id", Post.class)
                .setParameter("topic_id", topicId)
                .getResultList();

        return posts;
    }
}
