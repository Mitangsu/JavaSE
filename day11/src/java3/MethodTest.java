package java3;

import java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author shkstart
 * @create 2021-12-24 3:29
 */
public class MethodTest {

    @Test
    public void test() {

        Class clazz = Person.class;

        //getMethods():获取当前运行时类及其父类中声明为public访问权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
            System.out.println(m1);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明过的所有方法.(不包含父类中的声明的方法)
        Method[] d1 = clazz.getDeclaredMethods();
        for (Method m2 : d1) {
            System.out.println(m2);
        }

    }
    /*
    @Xxxx
    权限修饰符 返回值类型 方法名(参数列表1 形参名1,...)throw XxxException{}
     */

    @Test
    public void test2() {
        Class clazz = Person.class;
        Method[] d1 = clazz.getDeclaredMethods();
        for (Method m2 : d1) {
            //1.获取方法声明的注释
            Annotation[] annotations = m2.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m2.getModifiers()) + "\t");


            //3.返回值类型
            System.out.print(m2.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m2.getName());
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = m2.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {

                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
                System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m2.getExceptionTypes();
//
            if(exceptionTypes.length > 0){
                System.out.print("throw ");
                for (int i = 0; i < exceptionTypes.length; i++){
                    if (i == exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName()+",");
                }

            }

            System.out.println();
            }
        }

    }
