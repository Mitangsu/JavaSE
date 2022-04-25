package java1;

/**
 * 测试Thread中的常用方法：
 * 1.start():启动当前线程,调用当前线程的run()方法
 * 2.run():通常需要重写Thread类中的此方法,将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法代,返回当前码执行的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 可以通过“对象.setName(线程名)”来调用,也可以通过构造器来命名
 * 主线程命名Thread.currentThread().setName(线程名);
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程A中调用线程B的join()方法,此时线程A进入阻塞状态,
 * 直到线程B完全执行以后,线程A才结束阻塞状态,然后执行。
 * 8.stop():已过时.当执行此方法时,强制结束当前线程.
 * 9.sleep(Long millitime):让当前线程“睡觉”指定的millitime毫秒。
 * 在指定millitime毫秒时间内,当前线程是阻塞问题。
 * 10.isAlive():判断当前线程是否存活
 * <p>
 * <p>
 * 线程的优先级:
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5 -->默认的优先级
 * 2.如何获取和设置当前线程的优先级:
 * getPriority(): 获取线程的优先级
 * setPriority(int p):设置线程的优先级
 * <p>
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权.但是只从概率上讲,高优先级的线程高概率的情况下
 * 被执行.并不意味着只有当高优先级的线程执完以后,低优先级的线程才执行。
 *
 * @author shkstart
 * @create 2021-12-06 15:56
 */

class  HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(getName() + ":" + getPriority() + ":");
            }

//            if(i % 20 == 0){
//                yield();
//
//            }


        }

    }

    public HelloThread(String name) {
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("线程1");


//        h1.setName("线程1");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if(i == 20){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }
//        System.out.println(h1.isAlive());

    }


}
