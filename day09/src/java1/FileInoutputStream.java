package java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream
 *
 * 结论：
 * 1. 对于文本文件(.txt，.java，c，.cpp)，使用字符流来处理.
 * 2. 对于非文本文件(.jpg,.map3,,mp4,avi,.ppt...),使用字节流来处理.
 * 3.
 *
 *
 *
 * @author shkstart
 * @create 2021-12-19 15:33
 */
public class FileInoutputStream {

    //使用字节流FileInputStream处理文本文件,可能出现乱码.
    @Test
    public void testInputStream()  {
        FileInputStream in = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            in = new FileInputStream(file);

            //3.读数据
            byte[] arr = new byte[5];
            int len;//记录每次读取的数据的字节的个数
            while ((len = in.read(arr))!= -1){

                String str = new String(arr,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (in != null)
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
    /*
    实现对图片的复制


     */

    @Test
    public void test(){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File file = new File("美味.jpg");
            File file1 = new File("美味1.jpg");

            in = new FileInputStream(file);
            out = new FileOutputStream(file1);

            byte[] arr = new byte[5];
            int len;
            while ((len = in.read(arr)) != -1){
                out.write(arr,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }







    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);

            in = new FileInputStream(file);
            out = new FileOutputStream(file1);

            byte[] arr = new byte[1024];
            int len;
            while ((len = in.read(arr)) != -1){
                out.write(arr,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){

        long start = System.currentTimeMillis();

        String s1 = "C:\\Users\\陈轩\\Desktop\\01-视频.avi";
        String s2 = "C:\\Users\\陈轩\\Desktop\\02-视频.avi";

//        String s3 = "hello.txt";
//        String s4 = "heloooo.txt";

        copyFile(s1,s2);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为："+(end - start));//2408
    }


}
