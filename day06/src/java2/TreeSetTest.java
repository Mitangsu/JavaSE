package java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author shkstart
 * @create 2021-12-15 13:36
 */
public class TreeSetTest {

    /*
    1.向TreeSet中添加的数组，要求是相同类的对象
    2.两种排序方法：自然排序（实现Comparable接口） 和 定制排序（Comparator接口）


    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0,不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0,不再是equals().



     */

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",18));
        //举例一：
//        set.add(23);
//        set.add(-12);
//        set.add(34);
//        set.add(55);

        //举例二：
        set.add(new User("Tom",18));
        set.add(new User("Jerry",21));
        set.add(new User("Jack",20));
        set.add(new User("Mike",19));
        set.add(new User("Mike",56));

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test2(){

        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                    if (o1 instanceof User && o2 instanceof  User){
                        User u1 =(User)o1;
                        User u2 =(User)o2;
                        return Integer.compare(u1.getAge(),u2.getAge());

                    }else{
                        throw new RuntimeException("输入的数据类型不匹配");
                    }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",18));
        set.add(new User("Jerry",21));
        set.add(new User("Jack",20));
        set.add(new User("Mike",19));
        set.add(new User("Mie",19));
        set.add(new User("Mike",56));

        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    }

