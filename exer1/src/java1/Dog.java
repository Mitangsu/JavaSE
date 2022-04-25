package java1;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2022-01-10 19:43
 */
public class Dog {

    @Test
    public void test1(){

//基本数据类型转包装类

    //自动装箱
    int num1 = 10;
    Integer in1 = num1;

//包装类转基本数据类型

    //自动拆箱
    int num2 = in1;

//基本数据类型、包装类转String类型

        //连接运算
        String n1 = num1 + " ";

        //调用String的                valueOf(Xxx)；
        float f1 = 12.3f;
        String s = String.valueOf(f1);

//String类型转基本数据类型、包装类  parseXxx();
    String str = "123";
    int i = Integer.parseInt(str);


    }

}
