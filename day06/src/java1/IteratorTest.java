package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 *   默认游标都再集合的第一个元素之前.
 * 3.内部定义了remove()，可以再遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *   如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
 *   再调用remove都会报IllegalStateException。
 *
 *
 * @author shkstart
 * @create 2021-12-14 15:43
 */
public class IteratorTest {

    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());
        
        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//
//        }

        //方式三：推荐
        //hasNext():判断是否还要下一个元素
        while(iterator.hasNext()){
            //next():①指针下移②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

//        //错误一：
//        Iterator iterator = coll.iterator();
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }

    }

    //测试Iterator中的remove()方法
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            //iterator.remove() 错误
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }
        //
         iterator = coll.iterator();

        //遍历集合
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
