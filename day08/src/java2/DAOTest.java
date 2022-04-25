package java2;

import org.junit.Test;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-16 21:28
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();

        Student inex = dao2.getInex(1);


    }
}
