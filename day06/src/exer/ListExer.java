package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-15 1:13
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)方法


     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        updateList(list);

        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(new Integer(2));
    }

}
