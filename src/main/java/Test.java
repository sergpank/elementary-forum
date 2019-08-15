import org.elementary.forum.dao.UserDao;

public class Test
{
  public static void main(String[] args)
  {
    UserDao dao = new UserDao();
    System.out.println(dao.getByLogin("Barsa"));
  }
}
