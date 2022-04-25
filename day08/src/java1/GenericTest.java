package java1;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 * 总结：
 * ①集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 * ②在实例化集合类时,可以指明具体的泛型类型
 * ③指明完以后，在集合类或接口中凡是定义类或接口时,内部结构(比如：方法、构造器、属性等)使用到类的泛型的位置，都指定为实例化的泛型类型。
 *  比如：add(E e) --->实例化以后：add(Integer e)
 *
 * ④注意点：泛型的类型必须是类，不能是基本数据类。需要用到基本数据类型的位置，拿包装类替换。
 * ⑤如果实例化时，没有指明泛型的类型。默认类型为java.Lang.Object.
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口; 泛型方法
 *
 * @author shkstart
 * @create 2021-12-16 16:45
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//      list.add("Tom");

        for (Object score : list){
            //问题二：强转时，可能出现类型转换异常ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList举例
    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<Integer>();


        list.add(56);
        list.add(78);
        list.add(89);
        list.add(213);
        //编译时,就会进行类型检查，保证数据的安全
//      list.add("Tom");
          //方式一：
//        for (Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//        }
          //方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

        //在集合中使用泛型的情况：以HashMap为例

    }
    @Test
    public void test3(){
//      Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新类型：类型推断
        Map<String,Integer> map = new HashMap<>();


        map.put("Tom",67);
        map.put("Jerry",126);
        map.put("Jack",12);
        //不满足形参的要求
//      map.put(123,123);
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Integer> entry1 = iterator.next();
                String key = entry1.getKey();
                Integer value = entry1.getValue();
                System.out.println(key + "----" + value);
            }




    }
    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时,指明泛型参数的类型.
        List<Integer> integers = order.copyFromArrayToList(arr);

        System.out.println(integers);
    }
}
