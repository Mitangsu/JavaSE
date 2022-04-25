package java1;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 *  |----Map:双列数据，存储key-value对的数据 ----类似于高中的函数：y=f(X)
 *          |----HashMap:作为Map的主要实现类：线程不安全，效率高;存储null的key和value
 *               |-----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历.
 *                          原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                          对于频繁的遍历操作，此类执行效率高于HashMap.
 *          |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。
 *                       底层使用红黑树
 *          |----Hashtable:作为古老的实现类：线程安全的，效率低;不能null的key和vale
 *               |----Properties: 常用来处理配置文件。key和value都是String类型
 *
 *
 *      HashMap的底层：数组+链表  (jdk7及之前)
 *                    数组+链表+红黑树(jdk 8)
 *
 *面试题：
 * 1.HashMap的底层实现原理？
 * 2.HashMap 和 Hashtable的异同
 * 3.CurrentHashMap 与 Hashtable的异同？
 *
 * 二、Map结构的理解：
 *     Map中的key:无序的、不可重复的，使用Set存储所有的key --->key所在的类重写equals()和hashCode() (以HashMap为例)
 *     Map中的value：无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 *     一个键值对key-value构成了一个Entry对象。
 *     Map中的entry:无序的、不可重复的，使用Set存储所有的Entry
 *
 *三、HashMap的底层实现原理?以jdk7为例说明：
 *    HashMap map = new HashMap();
 *    在实例化以后，底层创建了长度是16的一维数组Entry[] table.
 *    ...可能以及执行过多次put...
 *    map.put(key1,value1);
 *    首先，调用key1所在类的hashCoder()计算key1哈希值，此哈希值经过某种算法以后，得到在Entry数组中的存放位置.
 *    如果此位置上的数据为空,此时的key1-value1添加成功 ---情况1
 *    如果此位置上的数据不为空,(意味着此位置上存在一个或多个数据(以链表形式存在)),比较我们和以及存在的一个或多个数据
 *    的哈希值:
 *            如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功. ----情况2
 *            如果key1的哈希值与某一个数据的哈希值相同了,继续比较：调用Key1所在类的equals()方法，比较：
 *                  如果equals()返回false:此时key1-value1添加成功. ----情况3
 *                  如果equals()返回true:使用value1替换key的value值
 *
 *             补充：关于情况2和情况3：此时key1-value和原来的数据以链表的方法存储.
 *
 *           在不断的添加过程中,会涉及到扩容问题,当超出临界值(且要存放的位置非空)时,扩容默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来
 *
 *           jdk8 相较于jdk7在底层实现方面的不同：
 *           1.new HashMap():底层没有创建一个长度为16的Node数组
 *           2.jdk8 底层的数组是Node[],而非Entry[]
 *           3.首次调用put()方法时,底层创建长度为16的数组
 *           4.jdk7底层结构只有:数组+链表。jdk8中底层结构：数组+链表+红黑树.
 *             当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时,
 *             此时此索引位置的所有数据改为使用红黑树存储.
 *
 *  四、LinkedHashMap的底层实现原理(了解)
 *
 *
 *
 *  五、Map接口中定义的方法：
  添加、删除、修改操作：
      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
      void putAll(Map m):将m中的所有key-value对存放到当前map中
      Object remove(Object key)：移除指定key的key-value对，并返回value
      void clear()：清空当前map中的所有数据
  元素查询的操作：
      Object get(Object key)：获取指定key对应的value
      boolean containsKey(Object key)：是否包含指定的key
      boolean containsValue(Object value)：是否包含指定的value
      int size()：返回map中key-value对的个数
      boolean isEmpty()：判断当前map是否为空
      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
  元视图操作的方法：
      Set keySet()：返回所有key构成的Set集合
      Collection values()：返回所有value构成的Collection集合
      Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 *   总结：常用方法：
 *   添加： put(Object key,Object value)
 *   删除： remove(Object key)
 *   修改： put(Object key,Object value)
 *   查询： get(Object key)
 *   长度： size()
 *   遍历： keySet()/values() /entrySet()
 *
 *
 * @author shkstart
 * @create 2021-12-15 15:49
 */
public class MapTest {
    /*
添加、删除、修改操作：
      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
      void putAll(Map m):将m中的所有key-value对存放到当前map中
      Object remove(Object key)：移除指定key的key-value对，并返回value
      void clear()：清空当前map中的所有数据
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",123);
        //修改
        map.put("AA",87);

        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);

        System.out.println(map);

        //remove(Object key)
        Object cc = map.remove("CC");
        System.out.println(cc);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());//0


    }
    /*
 元素查询的操作：
      Object get(Object key)：获取指定key对应的value
      boolean containsKey(Object key)：是否包含指定的key
      boolean containsValue(Object value)：是否包含指定的value
      int size()：返回map中key-value对的个数
      boolean isEmpty()：判断当前map是否为空
      boolean equals(Object obj)：判断当前map和参数对象obj是否相等



     */
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",123);

        //Object get(Object key)
        Object o = map.get(45);
        System.out.println(o);

        //boolean containsKey(Object key)
        boolean bb = map.containsKey("BB");
        System.out.println(bb);

        //boolean containsValue(Object value)
        System.out.println(map.containsValue(123));

        //boolean isEmpty()
        map.clear();
        System.out.println(map.isEmpty());
    }
    /*
      元视图操作的方法：
      Set keySet()：返回所有key构成的Set集合
      Collection values()：返回所有value构成的Collection集合
      Set entrySet()：返回所有key-value对构成的Set集合


     */

    @Test
    public void test4() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 12);
        map.put("BB", 153);

        //遍历所有的key集Set keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历所有的value//Collection values()
        Collection values = map.values();
        for (Object v1 : values) {
            System.out.println(v1);

        }
        System.out.println();
        //遍历所有的key-value Set entrySet()
        //方式一：entrySet()
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Object object = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) object;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        //方式二：
        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
           Object key = iterator2.next();
           Object value = map.get(key);
            System.out.println(key + "====="+value);
        }
    }

    @Test
    public void test1(){
        Map map = new HashMap();

        map.put(null,null);

        Map map1 = new Hashtable();

//        map1.put(null,null);  w

    }
}
