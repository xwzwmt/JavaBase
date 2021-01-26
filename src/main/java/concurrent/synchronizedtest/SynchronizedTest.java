package concurrent.synchronizedtest;

import java.util.concurrent.CountDownLatch;

public class SynchronizedTest {
    private static int total=0;
    private static Object object=new Object();
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        for(int i=0;i<10;i++){
            new Thread(()->{
                try{
                    //所有的线程创建好以后都处于等待状态
                    countDownLatch. await();
                    for(int j=0;j<1000;j++){
                        total++;
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(500);
        //线程启动
        countDownLatch.countDown();
        Thread.sleep(2000);
        System.out.println(total);
    }
}
