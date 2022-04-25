package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection、Map的工具类
 * 排序操作：（均为static方法）
     reverse(List)：反转 List 中元素的顺序
     shuffle(List)：对 List 集合元素进行随机排序
     sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 查找、替换
     Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
     给定集合中的最大元素
     Object min(Collection)
     Object min(Collection，Comparator)
     int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     void copy(List dest,List src)：将src中的内容复制到dest中
     boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
     List 对象的所有旧值
 *
 *
 *
 *面试题：Collection 和 Collections的区别
 * @author shkstart
 * @create 2021-12-16 10:01
 */
public class CollectionsTest {
    @Test
    public void test2(){
        List list  = new ArrayList();
        list.add(123);
        list.add(1233);
        list.add(45);
        list.add(15);
        list.add(1200);

        //报异常
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

        /*

         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }
    @Test
    public void test1(){
        List list  = new ArrayList();
        list.add(123);
        list.add(1233);
        list.add(45);
        list.add(15);
        list.add(1200);
        list.add(1200);
        list.add(1200);

        System.out.println(list);

//        Collections.reverse(list);反转排序
//        Collections.shuffle(list);随机排序
//        Collections.sort(list);从小到大排序
//        Collections.swap(list,1,2);交换1和2索引上的元素
//        System.out.println(Collections.max(list));查询集合中的最大值
//        System.out.println(Collections.frequency(list, 1200));//1200在集合List出现了几次

        System.out.println(list);
    }

}
