import org.elementary.forum.dao.UserDao;
import org.elementary.forum.entites.User;

import java.util.List;

public class Test
{
  public static void main(String[] args)
  {

    UserDao dao = new UserDao();
    //System.out.println(dao.getById(7));
    List<User> users = dao.getByLogin("Barsa");
    for (int i = 0; i < users.size(); i++) {
      System.out.println(users.get(i));
    }
  }
}
