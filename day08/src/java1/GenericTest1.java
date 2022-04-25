package java1;

import org.junit.Test;

import java.util.ArrayList;

/**如何自定义泛型结构：泛型类、泛型接口; 泛型方法
 * 1.关于自定义泛型类、泛型接口：
 *
 * @author shkstart
 * @create 2021-12-16 19:39
 */
public class GenericTest1 {

    @Test
    public void test(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();


        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("orderAA",1001,"order:AA");
        order1.setOrderT("AA:hello");

    }
    @Test
    public void test1(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(12233);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值。

        ArrayList<String> list = null;
        ArrayList<Integer> list1 = null;

    }

}
