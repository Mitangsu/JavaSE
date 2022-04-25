package java2;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 * http://localhost:8080 /examples/beauty.jpg?username =Tom
 * 协议      主机名  端口号   资源地址          参数列表
 * @author shkstart
 * @create 2021-12-22 19:26
 */
public class URLTest {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080 /examples/beauty.jpg?username =Tom");

//            public String getProtocol( ) 获取该URL的协议名
            url.getProtocol();//http
//            public String getHost( ) 获取该URL的主机名
            url.getHost();//localhost
//            public String getPort( ) 获取该URL的端口号
            url.getPort();//8080
//            public String getPath( ) 获取该URL的文件路径
            url.getPath();//examples/beauty.jpg
//            public String getFile( ) 获取该URL的文件名
            url.getFile();//examples/beauty.jpg?username =Tom
//            public String getQuery( ) 获取该URL的查询名
            url.getQuery();//username =Tom




        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
