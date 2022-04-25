package java5;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类:为了在程序中避免出现空指针异常而创建的.
 *
 * 常用的方法：ofNullable(T t)
 *            orElse(T t)
 *
 *
 * @author shkstart
 * @create 2021-12-26 10:35
 */
public class OptionalTest {

    /*
 Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
 Optional.empty() : 创建一个空的 Optional 实例
 Optional.ofNullable(T t)：t可以为null
     */

    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //of(T t):保证t是非空的
        Optional<Girl> girl1 = Optional.of(girl);

    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl =null;
        //ofNullable(T t):t可以是null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
        //ofElse(T t1):如果当前的Optional内部封装的t是非空的,则返回内部的t,
        //如果内部封装的t是空的,则返回ofElse方法中的参数t1.
        Girl girl2 = girl1.orElse(new Girl("奥利给"));
        System.out.println(girl2);
    }
    public String getGrilName(Boy boy){


        return boy.getGirl().getName();

    }



    @Test
    public void test3(){
        Boy boy = new Boy();
        String grilName = getGrilName(boy);
        System.out.println(grilName);

    }
    //优化以后的getGrilName():
    public String getGrilName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return  girl.getName();
            }
        }
        return null;

    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String grilName = getGrilName1(boy);
        System.out.println(grilName);

    }
    //使用Optional类的getGrilName():
    public String getGrilName2(Boy boy){

        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy2 = boy1.orElse(new Boy(new Girl("嘿嘿")));

        Girl girl = boy2.getGirl();
        //gril1一定非空
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();




    }
    @Test
    public void test5(){
        Boy boy = null;//"嘿嘿"
        boy = new Boy();//"古力娜扎"
        boy = new Boy(new Girl("苍老师"));
        String grilName2 = getGrilName2(boy);
        System.out.println(grilName2);


    }



}
