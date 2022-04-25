package java1;

/**
 *
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就被确定下来了.
 *
 * @author shkstart
 * @create 2021-12-25 0:13
 */

interface ClothFactory{

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象进行实例化


    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些收尾工作");
    }

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

}
//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory factory = new ProxyClothFactory(nike);

        factory.produceCloth();

    }

}
