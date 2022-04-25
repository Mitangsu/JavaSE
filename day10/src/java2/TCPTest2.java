package java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2:客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author shkstart
 * @create 2021-12-22 16:46
 */
public class TCPTest2 {

    @Test
    public void client()  {


        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8890);
            os = socket.getOutputStream();
            fis = new FileInputStream("美味.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);

            }
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
        }






    }
    /*
    涉及到的异常使用try-catch-finally处理

     */

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(8890);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("美味5.jpg"));

        byte[] arr = new byte[1024];
        int len;
        while ((len = is.read(arr))!= -1){
            fos.write(arr,0,len);

        }

        fos.close();
        is.close();
        accept.close();
        ss.close();


    }

}
