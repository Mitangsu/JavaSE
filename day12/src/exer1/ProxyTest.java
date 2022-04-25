package exer1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shkstart
 * @create 2021-12-25 14:22
 */

interface Human{

    String Believe();

    void eat(String food);


}

//被代理类
class SuperMan implements Human{

    @Override
    public String Believe() {
        return "我会飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);

    }
}


class getProxy1 {

    public static Object getProxy2(Object obj){

        getProxy3 getProxy3 = new getProxy3(obj);




        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),getProxy3);


    }


}

class getProxy3 implements InvocationHandler{


    private Object obj;

    public getProxy3(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(obj, args);
        return invoke;


    }
}




public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human h1 =(Human) getProxy1.getProxy2(superMan);

        h1.Believe();
        h1 .eat("汉堡");

    }
}








