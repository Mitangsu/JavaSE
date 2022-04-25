package java1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2021-12-19 22:43
 */
public class PicTest {
    //对图片的加密
    @Test
     public void test()  {

        FileInputStream fis = null;
        FileOutputStream fis1 = null;
        try {
            fis = new FileInputStream("美味.jpg");
            fis1 = new FileOutputStream("美味10.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!= -1){
                //字节数组进行修改
                //错误的
    //            for (byte b : buffer){
    //                b = (byte)(b ^ 5);
    //            }
                //正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);

                }
                fis1.write(buffer,0,len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis1 != null){
                try {
                    fis1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    //对图片的加密
    @Test
    public void test1()  {

        FileInputStream fis = null;
        FileOutputStream fis1 = null;
        try {
            fis = new FileInputStream("美味10.jpg");
            fis1 = new FileOutputStream("美味4.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer))!= -1){
                //字节数组进行修改
                //错误的
                //            for (byte b : buffer){
                //                b = (byte)(b ^ 5);
                //            }
                //正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);

                }
                fis1.write(buffer,0,len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis1 != null){
                try {
                    fis1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
