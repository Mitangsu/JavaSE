package exer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shkstart
 * @create 2021-12-25 4:13
 */

interface Human{

    String getBelief();

    void eat(String food);


}

//被代理类
class Superman implements Human{


    @Override
    public String getBelief() {
        return "我会飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我爱吃"+food);
    }
}

class getProxy1{

    public static Object getProxy2(Object obj){
        In in = new In(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),in);

    }

}

class In implements InvocationHandler{

    private Object obj;

    public In(Object obj) {
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
        Superman superman = new Superman();
        Human proxy2 = (Human)getProxy1.getProxy2(superman);


    }
}
