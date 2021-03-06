package java1;

/**
 * 多线程的创建:方式一:继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类中run()-->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 例子:遍历100以内的所有的偶数
 *
 * @author shkstart
 * @create 2021-12-06 14:41
 */

//1.创建一个继承于Thread的子类
class MyThread extends Thread {

    //2.重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();


        //4.通过此对象调用start():①启动当前线程 ②调用当前线程的run()方法
        t1.start();

        //问题一:我们不能通过直接调用run()的方法启动线程.
//      t1.run();

        //问题二:再启动一个线程,遍历100以内的偶数.//不可以还让已经start()的线程去执行.//会报ILLegalL ThreadStateException异常
        //t1.run();
        //需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();


            //如下的操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "**********************88");
            }

        }
    }

}












