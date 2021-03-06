package java1;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author shkstart
 * @create 2021-12-24 1:11
 */
public class NewInstanceTest {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*
        newInstance():调用此方法，创建对应的运行时类的对象.内部调用了运行时类的空参构造器.

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够.通常，设置为public.


        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时,默认调用super()时，保证父类有此构造器
         */
        Class<Person> clazz =Person.class;
        Person o = clazz.newInstance();
        System.out.println(o);


}
    //体会反射的动态性
    @Test
    public void test1(){

        int i = new Random().nextInt(3);//0,1,2
        String classPath = "";
        switch (i){
            case 0:
                classPath = "java.util.Date";
                break;

            case 1 :
                classPath = "java.lang.Object";
                break;

            case 2:
                classPath = "java1.Person";
                break;

        }
        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }



    }
    /*
    创建一个指定类的对象。
    classPath：指定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();


    }
}
