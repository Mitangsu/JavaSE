package java3;

import java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author shkstart
 * @create 2021-12-24 15:38
 */
public class OtherTest {

    /*
    获取构造器结构


     */
    @Test
    public void test(){

        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] dcs = clazz.getDeclaredConstructors();
        for (Constructor d : dcs){
            System.out.println(d);
        }

    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test1(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);


    }
    /*
    获取运行时类的带泛型父类
     */
    @Test
    public void test2(){
        Class clazz = Person.class;

        Type type = clazz.getGenericSuperclass();
        System.out.println(type);


    }
    /*
    获取运行时类的带泛型父类的泛型

    代码：逻辑代码 vs 功能性代码

     */
    @Test
    public void test3(){
        Class clazz = Person.class;

        Type type = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        //获取泛型类型
        Type[] arguments = paramType.getActualTypeArguments();
//        System.out.println(arguments[0].getTypeName());
        System.out.println(((Class)arguments[0]).getName());

    }
    /*

    获取运行时类实现的接口

     */
    @Test
    public void test5(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class d : interfaces){
            System.out.println(d);
        }

        System.out.println();
        //获取运行时类的父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class d : interfaces1){
            System.out.println(d);
        }

    }
    /*
    获取运行时类所在的包

     */
    @Test
    public void test6() {
        Class clazz = Person.class;

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);


    }

    /*
    获取运行时类声明的注解

     */
    @Test
    public void test7() {
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a :annotations){
            System.out.println(a);
        }


    }
}
