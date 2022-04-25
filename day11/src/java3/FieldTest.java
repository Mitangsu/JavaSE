package java3;

import java2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *获取当前运行时类的属性结构
 *
 * @author shkstart
 * @create 2021-12-24 3:06
 */
public class FieldTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f1 : fields){
            System.out.println(f1);
        }

        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明过的所有属性.(不包含父类中的声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f2 : declaredFields){
            System.out.println(f2);
        }

        //获取方法结构

    }
    //权限修饰符 数据类型 变量名
    @Test
    public void test(){
        Class personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f2 : declaredFields){
            //1.权限修饰符
            int mods = f2.getModifiers();
            System.out.print(Modifier.toString(mods)+"\t");

            //2.数据类型
            Class type = f2.getType();
            System.out.print(type.getName()+"\t");

            //3.变量名
            String name = f2.getName();
            System.out.print(name);

            System.out.println();

        }

    }

}
