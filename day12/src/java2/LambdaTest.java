package java2;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 *
 * 1.举例：(o1,o2) ->Integer.compare(o1,o2);
 * 2.格式：
 *      ->：Lambda操作符 或 箭头操作符
 *      ->左边：Lambda形参列表(其实就是接口中的抽象方法的形参列表)
 *      ->右边：Lambda体(其实就是重写的抽象方法的方法体)
 *
 * 3.Lambda表达式的使用：（分为6种情况介绍）
 *
 *
 *
 * @author shkstart
 * @create 2021-12-25 15:15
 */
public class LambdaTest {

    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱你宝贝曼");
            }
        };
        r1.run();

        System.out.println("***********************");

        Runnable r2 = () -> System.out.println("我爱你宝贝曼曼");

        r2.run();

    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("*****************************");

        //Lambda表达式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);


        System.out.println("*****************************");

        //方法引用
        Comparator<Integer> com3 =  Integer::compare;
        int compare3 = com3.compare(12, 21);
        System.out.println(compare3);



    }






}
