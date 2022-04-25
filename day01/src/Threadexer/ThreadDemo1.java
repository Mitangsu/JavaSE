package Threadexer;

/**
 * @author shkstart
 * @create 2021-12-07 15:12
 */

class WWThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            System.out.println(getName()+i);
        }
    }
}


public class ThreadDemo1 {
    public static void main(String[] args) {
//        WWThread w1 =new WWThread();
//        w1.setName("线程1:");
//        w1.start();
//
//        WWThread w2 =new WWThread();
//        w2.setName("线程2:");
//        w2.start();


    }
}
