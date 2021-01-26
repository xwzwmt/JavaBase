package concurrent.synchronizedtest;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.CountDownLatch;

public class HeavyLockTest {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object a=new Object();
        Thread thread1=
            new Thread(()->{
                synchronized(a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });




        Thread thread2=
            new Thread(()->{

                synchronized(a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        Thread.sleep(5000);
        thread1.start();
        thread2.start();
    }
}
