package java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 例题3:从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 *       客户端。并关闭相应的连接。
 *
 * @author shkstart
 * @create 2021-12-22 17:39
 */
public class TCPTest3 {

    @Test
    public void client()  {


        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream  baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8891);
            os = socket.getOutputStream();
            fis = new FileInputStream("美味.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);

            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接收服务端回复
             is = socket.getInputStream();
             baos = new ByteArrayOutputStream();
            byte[] arr = new byte[20];
            int len1;
            while ((len1 = is.read(arr))!= -1){
                baos.write(arr,0,len1);
            }

            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






    }
    /*
    涉及到的异常使用try-catch-finally处理

     */

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(8891);

        Socket socket1 = ss.accept();

        InputStream is = socket1.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("美味10.jpg"));

        byte[] arr = new byte[1024];
        int len;
        while ((len = is.read(arr))!= -1){
            fos.write(arr,0,len);

        }
        //6.服务器端给予反馈
        OutputStream os = socket1.getOutputStream();
        os.write("你好，已经收到，非常好".getBytes());



        fos.close();
        is.close();
        socket1.close();
        ss.close();
        os.close();


    }

}
