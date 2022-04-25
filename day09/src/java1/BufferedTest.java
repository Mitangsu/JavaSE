package java1;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”再已又的流的基础上。
 *
 * @author shkstart
 * @create 2021-12-19 17:31
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */

    @Test
    public void test() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file = new File("美味.jpg");
            File file1 = new File("美味w.jpg");

            //2.造流
            //2.1创建了节点流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            //2.2创建缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时,内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }


    }

    //实现文件复制的方法
    public void copyFileWithBufferd(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file = new File(srcPath);
            File file1 = new File(destPath);

            //2.造流
            //2.1创建了节点流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);

            //2.2创建缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);

//                bos.flush();//刷新缓冲区


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时,内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void test1() {

        long start = System.currentTimeMillis();

        String s1 = "C:\\Users\\陈轩\\Desktop\\01-视频.avi";
        String s2 = "C:\\Users\\陈轩\\Desktop\\02-视频.avi";

//        String s3 = "hello.txt";
//        String s4 = "heloooo.txt";

        copyFileWithBufferd(s1, s2);

        long end = System.currentTimeMillis();

    System.out.println("复制操作花费的时间为：" + (end - start));//670
}

/*
使用BufferedReader 和BufferedWriter 实现文本文件的复制
 */
@Test
public void testBufferedReaderWriter()  {


    BufferedReader br = null;
    BufferedWriter bw = null;
    try {
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp2.txt")));

            //处理的方法：读入和输出
            //方式一：使用char[]数组
//            char[] arr = new char[1024];
//            int len;
//            while ((len = br.read(arr)) != -1){
//                bw.write(arr,0,len);
//
//            }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                //方法一：
                bw.write(data+"\n");//data中不包含换行符
                //方法二：
//                bw.write(data);
//                bw.newLine();//提供换行的操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
            }
            }

        }







    }
}











