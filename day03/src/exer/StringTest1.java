package exer;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author shkstart
 * @create 2021-12-09 19:26
 */
public class StringTest1 {
    /*
    String 与 byte[]之间的转换
    编码:String --> byte[]：调用String的getBytes()
    解码:byte[] --> String：调用String的构造器.


    编码：字符串 -->字节 (看得懂 ---> 看不懂的二进制数据)
    解码：编码的逆过程,字节 --> 字符串(看不懂的二进制数据 -->看得懂)


    说明：解码时，要求解码使用的字符集必须和编码时使用的字符集一致，否则会出现乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集：进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("**********************");
        String s1 = new String(bytes);//使用默认的字符集：进行解码
        System.out.println(s1);

        String s2 = new String(gbks);
        System.out.println(s2);//出现乱码。原因:编码集和解码集不一致！

        String s3 = new String(gbks,"gbk");
        System.out.println(s3);//没有出现乱码。原因:编码集和解码集一致！

    }



    /*
    String 与char[]之间的转换

    String -->char[]:调用String的toCharArray()
    char[] -->String:调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            System.out.print(charArray[i]+" ");

        }
        char[] arr =new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);




    }

    /*
    复习：
    String 与基本数据类型、包装类之间的转换。
    String ---> 基本数据类型、包装类:调用包装类的静态方法parseXxx(s1)

    基本数据类型、包装类--->String:调用重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String s1 = "123";
        int i = Integer.parseInt(s1);
        System.out.println(i);

        int i1 = 100;
        String s2 = 100+" ";
        System.out.println(s2);

        System.out.println(s1 == s2);//false

    }


}
