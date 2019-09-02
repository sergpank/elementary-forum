package org.elementary.forum.bo;

import org.elementary.forum.dao.jpa.JpaPostDao;
import org.elementary.forum.entities.Post;

import java.util.List;

public class PostBO
{
  private JpaPostDao dao = new JpaPostDao();

  public Post get(long postId)
  {
    return dao.getById(postId);
  }

  public Post save(Post post)
  {
    return dao.save(post);
  }

  public List<Post> loadAll(long topicId)
  {
    return dao.loadAll(topicId);
  }
}
