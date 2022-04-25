package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection接口中声明的方法的测试
 *
 *
 *结论：
 *向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals();
 *
 * @author shkstart
 * @create 2021-12-14 14:15
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",18));


        //1.contains(Object obj):判断当前集合中是否包含boj
        //我们在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains((new String("Tom"))));

        System.out.println(coll.contains(new Person("Jerry",18)));

        //2.containsALL(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        boolean b = coll.containsAll(coll1);
        System.out.println(b);
    }

    @Test
    public void test2(){
        //3.remove(Objec obj)：从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(new Person("Jerry",18));//必须重写方法
        System.out.println(coll);

        //4、removeAll(Collection coll1)：差集：从当前集合中一处coll1中所有的元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);


    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合。
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj)：要想返回true,需要当前集合和形参集合的元素都相同.
        Collection coll1 = new ArrayList();//Array是有序的 顺序不一样equals()也是不对的
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        System.out.println(coll.equals(coll1));//true

    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();//Array是有序的 顺序不一样equals()也是不对的
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 -->数组toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i]+ " ");

        }
        //拓展：数组 ---> 集合:调用Arrays类的静态方法asList()

        //9.iterator():返回Iterator接口的实例,用于遍历集合元素,放在IteratorTest.java中

    }
}















