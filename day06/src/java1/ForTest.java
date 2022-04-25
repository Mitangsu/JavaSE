package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 *
 * @author shkstart
 * @create 2021-12-14 16:39
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",18));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量(相当于for里的i) :集合对象)
        //其实内部还是调用了迭代器
        for (Object obj : coll){
            System.out.println(obj);

        }


    }
    @Test
    public void test2(){
        int [] arr = new int[]{1,2,3};
        //for(数组元素的类型 局部变量：数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void test3(){

        String[] arr =new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环foreash
        for (String s : arr){
            s = "GG";

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//MM

        }



    }


}
