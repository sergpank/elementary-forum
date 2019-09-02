import org.elementary.forum.dao.jpa.JpaTopicDao;
import org.elementary.forum.entities.Topic;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class JpaTopicDaoTest
{
  @Test
  public void testSaveAndGet()
  {
    Topic expected = new Topic();
    expected.setAuthor(null);
    expected.setDateCreated(new Date());
    expected.setTitle("Test Topic");

    JpaTopicDao dao = new JpaTopicDao();

    dao.save(expected);
    System.out.println("Topic saved: " + expected);

    Topic actual = dao.getById(expected.getId());

    System.out.println("Topic found: " + actual);
  }

  @Test
  public void testLoadAll()
  {
    JpaTopicDao dao = new JpaTopicDao();

    List<Topic> topics = dao.loadAll();

    for (Topic t : topics)
    {
      System.out.println(t);
    }
  }
}