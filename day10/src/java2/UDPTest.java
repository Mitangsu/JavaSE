package java2;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 *
 * @author shkstart
 * @create 2021-12-22 18:57
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发射的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }

    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket s = new DatagramSocket(9090);

        byte[] arr =new byte[100];
        DatagramPacket s1 = new DatagramPacket(arr,0,arr.length);

        s.receive(s1);

        System.out.println(new String(s1.getData(), 0, s1.getLength()));

        s.close();
    }


}
