import org.elementary.forum.dao.jpa.JpaPostDao;
import org.elementary.forum.dao.jpa.JpaTopicDao;
import org.elementary.forum.entities.Post;
import org.elementary.forum.entities.Topic;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class JpaPostDaoTest
{
  @Test
  public void testSaveAndGet()
  {
    Post expected = new Post();
    expected.setAuthorId(0);
    expected.setDateCreated(new Date());
    expected.setTopic(null);
    expected.setText("test text");

    JpaPostDao dao = new JpaPostDao();

    dao.save(expected);
    System.out.println("Post saved: " + expected);

    Post actual = dao.getById(expected.getId());

    System.out.println("Post found: " + actual);
  }

  @Test
  public void testLoadAll()
  {
    JpaPostDao dao = new JpaPostDao();

    List<Post> posts = dao.loadAll(1L);

    for (Post p : posts)
    {
      System.out.println(p);
    }
  }
}