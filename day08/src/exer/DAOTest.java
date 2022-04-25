package exer;

import java.util.List;

/**
 *
 * @author shkstart
 * @create 2021-12-18 11:43
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();



        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1003,20,"昆凌"));
        dao.save("1003",new User(1002,31,"奥利给"));


        dao.update("1003",new User(1003,30,"方文山"));

        dao.delete("1002");

        List<User> list = dao.list();
        System.out.println(list);


    }
}
