package java3;

import java2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类指定的结构:属性、方法、构造器
 *
 * @author shkstart
 * @create 2021-12-24 16:17
 */
public class RefilectionTest {
    /*

    不需要掌握

     */

    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Object o = clazz.newInstance();
        Person p1 = (Person) o;

        //获取指定的属性:要求运行时类中属性声明为public
        //通常不参用此方式
        Field id = clazz.getField("id");



        /*
        设置当前属性的值

        set():参数1：指明设置哪个对象的属性 参数2：将此属性设置为多少


         */

        id.set(p1, 1001);


        /*

        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值.
         */
        int pId = (int) id.get(p1);
        System.out.println(pId);

    }
    /*
    如何操作运行时类中指定的属性 -- 需要掌握
     */
    @Test
    public void testField1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Object o = clazz.newInstance();
        Person p1 = (Person) o;

        //getDeclaredField(String fieldName):获取运行时类指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p1,"Tom");

        System.out.println(name.get(p1));

    }
    /*
   如何操作运行时类中指定的方法 -- 需要掌握
    */
    @Test
    public void testField2() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p =(Person)clazz.newInstance();

        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1：指明获取方法的名称 参数2：指明获取的方法的形参列表
         */

        Method show = clazz.getDeclaredMethod("show",String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);
        /*
        3.调用方法的invoke():参数1：方法的调用者 参数2：给方法形参复制的实参
        invoke()的返回值即为对应类中调用的方法的返回值.
         */
        Object returnValue = show.invoke(p,"CHN");//String nation =p.show("CHN");
        System.out.println(returnValue);

        System.out.println("******************如何调用静态方法******************");

        //private static void show1()

        Method show1 = clazz.getDeclaredMethod("show1");

        show1.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值,则此invoke()返回null
//        Object invoke = show1.invoke(Person.class);
        Object invoke = show1.invoke(null);
        System.out.println(invoke);//方法的返回值 null


    }
    /*
    如何调用运行时类中指定的构造器 -- 不常用

     */

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表

         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person per =(Person) constructor.newInstance("Tom");
        System.out.println(per);



    }



}
