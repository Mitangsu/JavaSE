package Threadexer;

/**
 * @author shkstart
 * @create 2021-12-07 15:12
 */

class WwwThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}


public class ThreadDemo2 {
    public static void main(String[] args) {
        WwwThread w1 = new WwwThread();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);

        t1.setName("线程1:");
        t2.setName("线程2:");
        t1.start();
        t2.start();
    }

}
